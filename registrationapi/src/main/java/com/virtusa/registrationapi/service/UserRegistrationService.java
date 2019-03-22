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
	static Logger logger= Logger.getLogger(UserRegistrationService.class.getName());

	//save user
	@Transactional
	public User saveUser(User user) {

		logger.debug("service invoked for registration api");
		this.user = repository.save(user);
		return this.user;
	}

	
	//get user based on email
	public User getuserByEmail(String email) {	
		logger.debug("service invoked for get user by email");
		return repository.findByEmail(email);
	}
	
	//getting user based on id
	public Optional<User> getUser(Long id) {
		logger.debug("service invoked for get users by id");
		return repository.findById(id);
	}
	
	//getting users based on name
	public List<User> getUsersByName(String name){
		logger.debug("service invoked for getting users by name");
		return repository.findByName(name);
	}
	
	//getting all users
	public List<User> getAllUsers(){

		logger.debug("service invoked for getting all users");
		List<User> users=null;
		users=repository.findAll();
		return users;
	}
	
}
