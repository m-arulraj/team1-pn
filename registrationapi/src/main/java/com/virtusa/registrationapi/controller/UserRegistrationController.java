package com.virtusa.registrationapi.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	static Logger logger;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody User user) throws URISyntaxException {

		//get logger
		logger=Logger.getLogger(UserRegistrationController.class.getName());
		
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
}
