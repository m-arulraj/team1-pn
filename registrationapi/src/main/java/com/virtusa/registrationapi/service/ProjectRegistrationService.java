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
	
	public User user;
	public UserProject userProject;
	public Optional<Project> optProject;
	public List<Project> projects;
	public Project project;
	
	Logger logger=Logger.getLogger(ProjectRegistrationService.class);

	public Project saveProject(Project project,String email) {
		
		logger.debug("service invoked for saving Project");
		
		//get User by email
		User user= service.getUserByEmail(email);
		
		logger.debug("got user based on email");
		logger.debug(user.getEmail());
		
		user.getProjects().add(project);
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
	public void deleteProject(Project project,String email){
		
		logger.debug("service executed for deleting project");
		
		this.user=service.getUserByEmail(email);
		projects=projectRegistrationRepository.findByTypeAndRole(project.getType(), project.getRole());
		
		projects.stream().forEach(pro->{
			this.userProject=userProjectRepository.findByUserIdAndProjectId(this.user.getId(),pro.getId());
			
			logger.debug(userProject);
			this.optProject=projectRegistrationRepository.findById(pro.getId());
			logger.debug(optProject);
			if(userProject!=null){
				if(optProject.isPresent()){
					this.project=optProject.get();
				}
			}
			userProjectRepository.delete(userProject);
			projectRegistrationRepository.delete(this.project);
		});
		
	}

}
