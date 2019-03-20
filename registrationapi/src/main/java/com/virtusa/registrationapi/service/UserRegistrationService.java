package com.virtusa.registrationapi.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService {

	@Autowired
	private UserRegistrationRepository repository;
	private User user; 
	
	@Transactional
	public User saveUser(User user){
		
		this.user=repository.save(user);
		return this.user;
	}
}
