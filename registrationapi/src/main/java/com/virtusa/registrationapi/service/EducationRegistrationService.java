package com.virtusa.registrationapi.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.Education;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.repository.EducationRepository;
import com.virtusa.registrationapi.repository.UserRegistrationRepository;



@Service
public class EducationRegistrationService {

	@Autowired
	private EducationRepository educationRepository;
	@Autowired
	private UserRegistrationRepository userRegistrationRepository;
	
	private Education education;
	private User user;
	private Optional<Education> optEduction;
	
	//get logger
	private static Logger logger=Logger.getLogger(EducationRegistrationService.class);
	
	public Education saveEducation(Education education, String email){
		
		logger.debug("service executed for saving education");
		//get user object
		this.user=userRegistrationRepository.findByEmail(email);
			
		education.setUser(this.user);
		this.user.setEducation(education);
		
		logger.debug("highschool-->"+education.getHighschool());
		logger.debug(education.getIntermediate());
		logger.debug(education.getGraduation());
		logger.debug(education.getPostgraduation());
		
		return educationRepository.save(education);
		
	}
	
	public Education getEducation(String email){
		logger.debug("service invoked for gettig education details of user");
		this.user=userRegistrationRepository.findByEmail(email);
		
		optEduction=educationRepository.findByUser(this.user);
		if(optEduction.isPresent()){
			this.education=optEduction.get();
		}
		return this.education;
	}
	@Transactional
	public void deleteEducation(String email){
	
		logger.debug("dervice invoked for deleting education details");
		
		//get user
		this.user=userRegistrationRepository.findByEmail(email);
		
		this.education=this.user.getEducation();
		//educationRepository.deleteByUser(this.user);
		//educationRepository.delete(this.education);
		educationRepository.deleteById(this.education.getId());
	}
}
