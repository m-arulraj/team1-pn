package com.virtusa.registrationconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.util.EndpointConstant;

@Service
public class UserServiceImp implements UserService {

	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public User getUserByEmail(String email) {
		ResponseEntity<User> response = restTemplate.exchange(EndpointConstant.USER_SERVICE_URI+"user/email/"+email,
				HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
				});
		return response.getBody();
		
	}

	@Override
	public User login(String email, String Password) {
		ResponseEntity<User> response = restTemplate.exchange(EndpointConstant.USER_SERVICE_URI+"user/login/"+email+"/pwd/"+Password,
				HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
				});
		return response.getBody();
	}
	
	

}
