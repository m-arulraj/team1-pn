package com.virtusa.registrationconsumer.service;

import com.virtusa.registrationconsumer.domain.User;

public interface UserService {

	User getUserByEmail(String email);
	
	User login(String email,String Password);
}
