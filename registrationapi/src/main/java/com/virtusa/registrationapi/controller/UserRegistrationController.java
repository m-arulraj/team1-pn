package com.virtusa.registrationapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.registrationapi.domain.Skill;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.service.SkillRegistrationService;
import com.virtusa.registrationapi.service.UserRegistrationService;

@RestController
@RequestMapping("/api/user/registration")
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService userservice;

	@Autowired
	private SkillRegistrationService skillRegistration;

	Long userid;

	Long skillid;

	static Logger logger;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody User user) throws URISyntaxException {

		User userdata = userservice.saveUser(user);
		userid = userdata.getId();

		// get logger
		logger = Logger.getLogger(UserRegistrationController.class.getName());
		logger.info("regisration started");
		logger.debug("controller for user registration invoked");

		// call service method
		ResponseEntity<String> response = ResponseEntity
				.created(new URI("/api/user/registration/" + userservice.saveUser(user))).build();

		if (response.getStatusCodeValue() == 201) {
			logger.debug("registration successful");
		} else {
			logger.debug("http status code->" + response.getStatusCode());
			logger.debug("registration failed");
		}

		return response;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Optional<User> getuser(@PathVariable(name = "id") Long id) {

		return userservice.getusers(id);

	}
	
	
	//posting skill data
	@RequestMapping(value = "/addskill", method = RequestMethod.POST)
	public ResponseEntity<String> registerskill(@RequestBody Skill skill) throws URISyntaxException {

		Skill skilldata = skillRegistration.saveskill(skill);
		skillid = skilldata.getId();

		ResponseEntity<String> response = ResponseEntity
				.created(new URI("/api/user/registration/addskill" + skillRegistration.saveskill(skill).getId()))
				.build();

		return response;

	}
	//getting skill data based on id 
	@RequestMapping(value="/addskill/{id}",method=RequestMethod.GET)
	public Optional<Skill> getskills(@PathVariable(name="id") Long skillid){
		
		return skillRegistration.getallskills(skillid);
	}
	
	
	

}
