package com.virtusa.registrationapi.service;

import java.util.List;

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
	
	//get logger
	static Logger logger=Logger.getLogger(UserRegistrationController.class.getName());;
	
	@Transactional
	public User saveUser(User user){
		
		logger.debug("service invoked for registration api");
		this.user=repository.save(user);
		return this.user;
	}
	
	public User getUserByEmail(String email){
		User user=null;
	
		logger.debug("servce invokde for getting user by email");
		//get user object
		user=repository.findByEmail(email);
		logger.debug("returning user object");
		//return user
		return user;
	}
	
	public List<User> getUserByName(String name){
		List<User> users=null;
		
		logger.debug("service invokde for getting user by name");
		
		//get list of objects user object
		users=repository.findByName(name);
		
		logger.debug("rturning list of user objects");
		//return list
		return users;
	}
}
