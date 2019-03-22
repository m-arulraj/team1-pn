package com.virtusa.registrationapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.registrationapi.domain.Project;
import com.virtusa.registrationapi.domain.Skill;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.service.ProjectRegistrationService;
import com.virtusa.registrationapi.service.SkillRegistrationService;
import com.virtusa.registrationapi.service.UserRegistrationService;

@RestController
@RequestMapping("/api/user/registration")
public class UserRegistrationController {


	@Autowired
	private UserRegistrationService service;

	@Autowired
	private SkillRegistrationService skillRegistrationService;
	
	@Autowired
	private ProjectRegistrationService projectRegistrationService;
	
	Long userid;

	Long skillid;
	//get logger
	static Logger logger=Logger.getLogger(UserRegistrationController.class);

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody User user) throws URISyntaxException {
		
		logger.info("regisration started");
		
		logger.debug("controller for user registration invoked");
		
		//call service method 
		ResponseEntity<String> response = ResponseEntity
				.created(new URI("/api/user/registration/" + service.saveUser(user))).build();
		
		if(response.getStatusCodeValue()==201){
			logger.debug("registration successful");
		}else{
			logger.debug("http status code->"+response.getStatusCode());
			logger.debug("registration failed");
		}
		//return response
		return response;
	}
	
	//getting all users
	public List<User> getAllUsers(){
		logger.info("geting users");
		logger.debug("controller invoked for getting all users");
		List<User> users=null;
		users=service.getAllUsers();
		return users;
		
	}
	
	//getting user based on email
	@RequestMapping(value="/userforemail/{email}", method=RequestMethod.GET)
	public User getUserByEmail(@PathVariable String email){
		
		User user=null;
		logger.info("getting user");
		logger.debug("controller invoked for getting user");
		
		//get user object from service
		user=service.getuserByEmail(email);
		if(user!=null){
			logger.debug("got user obect");
		}else{
			logger.debug("couldn't get user object");
		}
		//return user
		return user;
	}
	
	//getting user based on name
	@RequestMapping(value="/usersforname/{name}", method=RequestMethod.GET)
	public List<User> getUserByName(@PathVariable String name){
		
		List<User> users=null;
		logger.info("getting users");
		logger.debug("controller invoked for getting user");
		//get user object from service
		users=service.getUsersByName(name);
		if(users!=null){
			logger.debug("got list of user object");
		}else{
			logger.debug("couldn't get list of user object");
		}
		//return user
		return users;
	}
	
	//getting user based o id 
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable(name = "id") Long id) {
		
		logger.info("getting user");
		logger.debug("controller invoked for getting user by id");
		return service.getUser(id);

	}

	//posting skill data
	@RequestMapping(value = "/addskill/{email}", method = RequestMethod.POST)
	public ResponseEntity<String> registerSkill(@RequestBody Skill skill, @PathVariable(name="email") String email) throws URISyntaxException {

		logger.info("registering skills");
		logger.debug("controller invoked for registering skill");
		
		ResponseEntity<String> response = ResponseEntity
				.created(new URI("/api/user/registration/" +skillRegistrationService.saveSkill(skill,email))).build();

		logger.debug("saved skill");
		logger.debug("returnning response");
		return response;
	}
	
	   //posting project data
		@RequestMapping(value = "/addproject/{email}", method = RequestMethod.POST)
		public ResponseEntity<String> registerProject(@RequestBody Project project, @PathVariable(name="email") String email) throws URISyntaxException {

			logger.info("registering project");
			logger.debug("controller invoked for registering project");
			
			ResponseEntity<String> response = ResponseEntity
					.created(new URI("/api/user/registration/" +projectRegistrationService.saveProject(project,email))).build();

			logger.debug("saved project");
			logger.debug("returnning response");
			return response;
		}
	
	//getting skill data based on id 
	@RequestMapping(value="/getskill/{id}",method=RequestMethod.GET)
	public Optional<Skill> getskill(@PathVariable(name="id") Long skillId){
		logger.info("getting skill");
		logger.debug("controller invoked for getting skill by id");
		return skillRegistrationService.getSkill(skillId);
	}
	
	//getting all skills
	@RequestMapping(value="/getskills",method=RequestMethod.GET)
	public List<Skill> getskills(){

		logger.info("getting skills");
		logger.debug("controller invoked for getting all skills");
		return skillRegistrationService.getSkills();
	}
	
	//getting skill based on name
	@RequestMapping(value="/getskillforname/{name}",method=RequestMethod.GET)
	public Optional<Skill> getskill(@PathVariable(name="name") String name){

		logger.info("getting skills");
		logger.debug("controller invoked for getting sill by name");
		return skillRegistrationService.getSkillByName(name);
	}
}
