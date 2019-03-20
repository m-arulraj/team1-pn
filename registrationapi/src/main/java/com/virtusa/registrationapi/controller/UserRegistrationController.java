package com.virtusa.registrationapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	User user;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public User registerUser(@RequestBody User user){
		this.user=service.saveUser(user);
		
		return this.user;
	}
}
