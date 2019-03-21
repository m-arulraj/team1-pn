package com.virtusa.registrationapi.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.controller.UserRegistrationController;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService {

	@Autowired
	private UserRegistrationRepository repository;
	private User user;
	static Logger logger;

	@Transactional
	public User saveUser(User user) {

		// get logger
		logger = Logger.getLogger(UserRegistrationController.class.getName());
		logger.debug("service invoked for registration api");
		this.user = repository.save(user);
		return this.user;
	}

	public User getuserByEmail(String email) {
		return repository.findByEmail(email);
		
	}
	
	public Optional<User> getusers(Long id) {
		return repository.findById(id);
		
	}
	public List<User> getUsersByName(String name){
		return repository.findByName(name);
	}
	
}
