package com.virtusa.registrationconsumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.virtusa.registrationconsumer.domain.Certificate;
import com.virtusa.registrationconsumer.domain.Education;
import com.virtusa.registrationconsumer.domain.Post;
import com.virtusa.registrationconsumer.domain.Project;
import com.virtusa.registrationconsumer.domain.Skill;
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

	@Override
	public void saveSkill(String email, Skill skill) {
		restTemplate.postForEntity(EndpointConstant.REGISTER_SERVICE_URI+"skill/email/"+email, skill, String.class);
		
	}

	@Override
	public void saveCertificate(String email, Certificate certificate) {
		
		restTemplate.postForEntity(EndpointConstant.REGISTER_SERVICE_URI+"certificate/email/"+email, certificate, String.class);
	}

	@Override
	public void saveEducation(String email, Education education) {
		restTemplate.postForEntity(EndpointConstant.REGISTER_SERVICE_URI+"education/email/"+email, education, String.class);
		
	}

	@Override
	public void saveProject(String email, Project project) {
		restTemplate.postForEntity(EndpointConstant.REGISTER_SERVICE_URI+"project/email/"+email, project, String.class);
		
	}

	@Override
	public List<User> searchByName(String name) {
		ResponseEntity<List<User>> response = restTemplate.exchange(EndpointConstant.USER_SERVICE_URI+"users/"+name,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
				});
		return response.getBody();
		
	}
	
	

}
