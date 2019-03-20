package com.virtusa.registrationapi.controller;

import java.net.URI;
import java.net.URISyntaxException;

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
	User user;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody User user) throws URISyntaxException {

		ResponseEntity<String> response = ResponseEntity
				.created(new URI("/api/user/registration/" + service.saveUser(user))).build();
		
		

		return response;
	}
}
