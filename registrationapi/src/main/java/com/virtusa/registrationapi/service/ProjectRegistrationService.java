package com.virtusa.registrationapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.Project;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.domain.UserProject;
import com.virtusa.registrationapi.repository.ProjectRegistrationRepository;
import com.virtusa.registrationapi.repository.UserProjectRepository;

@Service
public class ProjectRegistrationService {

	@Autowired
	ProjectRegistrationRepository projectRegistrationRepository;
	@Autowired
	UserProjectRepository userProjectRepository;
	@Autowired
	private UserRegistrationService service;
	
	Logger logger=Logger.getLogger(ProjectRegistrationService.class);

	public Project saveProject(Project project,String email) {
		
		logger.debug("service invoked for saving Project");
		
		//get User by email
		User user= service.getuserByEmail(email);
		
		logger.debug("got user based on email");
		logger.debug(user.getEmail());
		
		//get all users of Project
		Set<User> users=new HashSet<User>();
		logger.debug("got users of Project");
		//add current user object to set of users for Project
		users.add(user);
		logger.debug("users of Project are:");
		users.stream().forEach(u->
		logger.debug(u.getEmail())
		);
		
		//add updated list of users to skill
		project.setUsers(users);
		project.getUsers().stream().forEach(u->logger.debug("user of Project->"+u.getEmail()));
		
		logger.debug("saving Project having users");
				
		project=projectRegistrationRepository.save(project);
		
		UserProject userProject= new UserProject();
		userProject.setProjectId(project.getId());
		userProject.setUserId(user.getId());
		
		//save user Project
		userProjectRepository.save(userProject);
		
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
