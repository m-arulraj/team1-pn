package com.virtusa.registrationapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.service.UserRegistrationService;

@RestController
@RequestMapping("/api/user/registration")
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService service;

	//get logger
	static Logger logger=Logger.getLogger(UserRegistrationController.class);

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody User user) throws URISyntaxException {
		
		logger.info("regisration started");
		
		logger.debug("controller for user registration invoked");
		
		//call service method 
		ResponseEntity<String> response = ResponseEntity
				.created(new URI("/api/user/registration/" + service.saveUser(user))).build();
		
		if(response.getStatusCodeValue()==201){
			logger.debug("registration successful");
		}else{
			logger.debug("http status code->"+response.getStatusCode());
			logger.debug("registration failed");
		}
		//return response
		return response;
	}
	
	@RequestMapping(value="/userforemail/{email}", method=RequestMethod.GET)
	public User getUserByEmail(@PathVariable String email){
		
		User user=null;
		
		logger.debug("controller invoked for getting user");
		
		//get user object from service
		user=service.getUserByEmail(email);
		if(user!=null){
			logger.debug("got user obect");
		}else{
			logger.debug("couldn't get user object");
		}
		//return user
		return user;
	}
	
	@RequestMapping(value="/usersforname/{name}", method=RequestMethod.GET)
	public List<User> getUserByName(@PathVariable String name){
		
		List<User> users=null;
		
		logger.debug("controller invoked for getting user");
		
		//get user object from service
		users=service.getUserByName(name);
		if(users!=null){
			logger.debug("got list of user object");
		}else{
			logger.debug("couldn't get list of user object");
		}
		//return user
		return users;
	}
	
	
}
