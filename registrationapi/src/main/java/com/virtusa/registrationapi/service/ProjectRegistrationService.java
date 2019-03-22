package com.virtusa.registrationapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.Project;
import com.virtusa.registrationapi.domain.Skill;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.repository.ProjectRegistrationRepository;

@Service
public class ProjectRegistrationService {

	@Autowired
	ProjectRegistrationRepository projectRegistrationRepository;
	@Autowired
	private UserRegistrationService service;
	
	Logger logger=Logger.getLogger(ProjectRegistrationService.class);

public Project saveProject(Project project,String email) {
		
		logger.debug("service invoked for saving project");
		
		//get User by email
		User user= service.getuserByEmail(email);
		
		logger.debug("got user based on email");
		logger.debug(user.getEmail());
		
		Set<User> users=new HashSet<User>();
		logger.debug("got users of project");
		//add current user object to set of users for project
		users.add(user);
		logger.debug("users of project are:");
		users.stream().forEach(u->
		logger.debug(u.getEmail())
		);
		
		//add updated list of users to project
		project.setUsers(users);
		
		project.getUsers().stream().forEach(u->logger.debug("user of project->"+u.getEmail()));
		
		logger.debug("saving project having users");
		
		project=projectRegistrationRepository.save(project);	
		service.saveUser(user);
		return project;	
		
	}

	public Optional<Project> getProject(Long projectId) {
		logger.debug("service invoked for getting project");
		return projectRegistrationRepository.findById(projectId);
	}
	
	public List<Project> getProjects(){
		logger.debug("service invoked for getting project");
		return projectRegistrationRepository.findAll();
	}
	
	public Optional<Project> getProjectByType(String type){
		logger.debug("service invoked for getting project");
		return projectRegistrationRepository.findByType(type);
	}

}
