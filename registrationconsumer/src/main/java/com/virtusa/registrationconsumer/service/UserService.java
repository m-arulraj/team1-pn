package com.virtusa.registrationconsumer.service;

import java.util.List;

import com.virtusa.registrationconsumer.domain.Certificate;
import com.virtusa.registrationconsumer.domain.Education;
import com.virtusa.registrationconsumer.domain.Project;
import com.virtusa.registrationconsumer.domain.Skill;
import com.virtusa.registrationconsumer.domain.User;

public interface UserService {

	public User getUserByEmail(String email);
	
	public User login(String email,String Password);
	
	public void saveSkill(String email,Skill skill);
	
	public void saveCertificate(String email,Certificate certificate);

	public void saveEducation(String email, Education education);

	public void saveProject(String email, Project project);
	
	public List<User> searchByName(String name);
}
