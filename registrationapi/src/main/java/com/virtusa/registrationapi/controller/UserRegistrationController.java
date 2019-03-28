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

import com.virtusa.registrationapi.domain.Certificate;
import com.virtusa.registrationapi.domain.ProfessionalInformation;
import com.virtusa.registrationapi.domain.Project;
import com.virtusa.registrationapi.domain.Skill;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.service.CertificateRegistrationService;
import com.virtusa.registrationapi.service.ProfessionalInformationRegistrationService;
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
	private CertificateRegistrationService certificateRegistrationService;
	
	@Autowired
	private ProjectRegistrationService projectRegistrationService;
	
	@Autowired
	private ProfessionalInformationRegistrationService professionalInformationRegistrationService;
	
	//Long userid;

	//Long skillid;
	//get logger
	static Logger logger=Logger.getLogger(UserRegistrationController.class);

	@RequestMapping(value = "/user", method = RequestMethod.POST)
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
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User> getAllUsers(){
		logger.info("geting users");
		logger.debug("controller invoked for getting all users");
		List<User> users=null;
		users=service.getAllUsers();
		return users;
		
	}
	
	//getting user based on email
	@RequestMapping(value="/user/email/{email}", method=RequestMethod.GET)
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
	@RequestMapping(value="/users/{name}", method=RequestMethod.GET)
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
	
	//getting user based on id 
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable(name = "id") Long id) {
		
		logger.info("getting user");
		logger.debug("controller invoked for getting user by id");
		return service.getUser(id);

	}

	//posting skill data
	@RequestMapping(value = "/skill/email/{email}", method = RequestMethod.POST)
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
		@RequestMapping(value = "/project/email/{email}", method = RequestMethod.POST)
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
	@RequestMapping(value="/skill/{id}",method=RequestMethod.GET)
	public Optional<Skill> getskill(@PathVariable(name="id") Long skillId){
		logger.info("getting skill");
		logger.debug("controller invoked for getting skill by id");
		return skillRegistrationService.getSkill(skillId);
	}
	
	//getting all skills
	@RequestMapping(value="/skills",method=RequestMethod.GET)
	public List<Skill> getskills(){

		logger.info("getting skills");
		logger.debug("controller invoked for getting all skills");
		return skillRegistrationService.getSkills();
	}
	
	//getting skill based on name
	@RequestMapping(value="/skills/name/{name}",method=RequestMethod.GET)
	public Optional<Skill> getskill(@PathVariable(name="name") String name){

		logger.info("getting skills");
		logger.debug("controller invoked for getting sill by name");
		return skillRegistrationService.getSkillByName(name);
	}
	
	//posting ProfessionalInformation data
		@RequestMapping(value = "/professionalinformation/email/{email}", method = RequestMethod.POST)
		public ResponseEntity<String> registerProfessionalInformation(@RequestBody ProfessionalInformation professionalInformation, @PathVariable(name="email") String email) throws URISyntaxException {

			logger.info("registering ProfessionalInformation");
			logger.debug("controller invoked for registering ProfessionalInformation");
			
			ResponseEntity<String> response = ResponseEntity
					.created(new URI("/api/user/registration/" +professionalInformationRegistrationService.saveProfessionalInformation(professionalInformation,email))).build();

			logger.debug("saved ProfessionalInformation");
			logger.debug("returnning response");
			return response;
		}
		
		//getting ProfessionalInformation data based on id 
		@RequestMapping(value="/professionalinformation/{id}",method=RequestMethod.GET)
		public Optional<ProfessionalInformation> getProfessionalInformation(@PathVariable(name="id") Long professionalInformationId){
			logger.info("getting ProfessionalInformation");
			logger.debug("controller invoked for getting ProfessionalInformation by id");
			return professionalInformationRegistrationService.getProfessionalInformation(professionalInformationId);
		}
		
		//getting all ProfessionalInformation
		@RequestMapping(value="/professionalinformations",method=RequestMethod.GET)
		public List<ProfessionalInformation> getProfessionalInformations(){

			logger.info("getting ProfessionalInformation");
			logger.debug("controller invoked for getting all ProfessionalInformation");
			return professionalInformationRegistrationService.getProfessionalInformations();
		}
		
		//getting ProfessionalInformation based on name
		@RequestMapping(value="/professionalinformation/company/{name}",method=RequestMethod.GET)
		public Optional<ProfessionalInformation> getProfessionalInformations(@PathVariable(name="name") String companyName){

			logger.info("getting ProfessionalInformation");
			logger.debug("controller invoked for getting ProfessionalInformation by name");
			return professionalInformationRegistrationService.getProfessionalInformationByInstituteName(companyName);
		}
		
		//posting Certificate data
			@RequestMapping(value = "/certificate/email/{email}", method = RequestMethod.POST)
			public ResponseEntity<String> registerCertificate(@RequestBody Certificate certificate, @PathVariable(name="email") String email) throws URISyntaxException {

				logger.info("registering Certificate");
				logger.debug("controller invoked for registering Certificate");
				
				ResponseEntity<String> response = ResponseEntity
						.created(new URI("/api/user/registration/" +certificateRegistrationService.saveCertificate(certificate,email))).build();

				logger.debug("saved Certificate");
				logger.debug("returnning response");
				return response;
			}
			
			//getting Certificate data based on id 
			@RequestMapping(value="/certificate/{id}",method=RequestMethod.GET)
			public Optional<Certificate> getCertificate(@PathVariable(name="id") Long certificateId){
				logger.info("getting Certificate");
				logger.debug("controller invoked for getting Certificate by id");
				return certificateRegistrationService.getCertificate(certificateId);
			}
			
			//getting all Certificate
			@RequestMapping(value="/certificates",method=RequestMethod.GET)
			public List<Certificate> getCertificates(){

				logger.info("getting Certificate");
				logger.debug("controller invoked for getting all Certificate");
				return certificateRegistrationService.getCertificates();
			}
			
			//getting Certificate based on name
			@RequestMapping(value="/certificate/institute/{name}",method=RequestMethod.GET)
			public List<Optional<Certificate>> getCertificate(@PathVariable(name="name") String instituteName){

				logger.info("getting Certificate");
				logger.debug("controller invoked for getting Certificate by name");
				return certificateRegistrationService.getCertificateByInstituteName(instituteName);
			}
}
