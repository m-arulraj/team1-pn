package com.virtusa.registrationconsumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.registrationconsumer.domain.User;
import com.virtusa.registrationconsumer.util.EndpointConstant;

@Service
public class RegisterServiceImp implements RegisterService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public void saveUser(User user) {
		
		

		ResponseEntity<String> response = restTemplate.postForEntity(EndpointConstant.REGISTER_SERVICE_URI, user, String.class);
		 
	}

	@Override
	public User searchByEmail(String email) {

		User user = restTemplate.getForObject(EndpointConstant.REGISTER_SERVICE_URI, User.class, email);
		return user;
	}

	@Override
	public List<User> searchByName(String name) {

		ResponseEntity<List<User>> response = restTemplate.exchange(EndpointConstant.REGISTER_SERVICE_URI,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
				}, name);
		return response.getBody();
	}
	
	
	

}
