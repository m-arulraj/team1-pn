package com.virtusa.registrationapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.ProfessionalInformation;
import com.virtusa.registrationapi.domain.Skill;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.domain.UserProfessionalInformation;
import com.virtusa.registrationapi.repository.ProfessionalInformationRegistrationRepository;
import com.virtusa.registrationapi.repository.UserProfessionalInformationRepository;

@Service
public class ProfessionalInformationRegistrationService {

	@Autowired
	private ProfessionalInformationRegistrationRepository professionalInformationRepository;
	@Autowired
	private UserProfessionalInformationRepository userProfessionalInformationRepository;
	@Autowired
	private UserRegistrationService service;
	
	private  User user;
	private List<ProfessionalInformation> professionalInformations;
	private Optional<ProfessionalInformation> optProfessionalInformation;
	private UserProfessionalInformation userProfessionalInformation;
	private ProfessionalInformation professionalInformation;
	
	private static Logger logger=Logger.getLogger(ProfessionalInformationRegistrationService.class);
	
	
public ProfessionalInformation saveProfessionalInformation(ProfessionalInformation professionalInformation,String email) {
		
		logger.debug("service invoked for saving ProfessionalInformation");
		
		//get User by email
		User user= service.getUserByEmail(email);
		
		logger.debug("got user based on email");
		
		user.getProfessionalInformations().add(professionalInformation);
		service.saveUser(user);
		
		return professionalInformation;	
		
	}
		

	public Optional<ProfessionalInformation> getProfessionalInformation(Long professionalInformationId) {
		logger.debug("service invoked for getting ProfessionalInformation by id");
		return professionalInformationRepository.findById(professionalInformationId);
	}
	
	public List<ProfessionalInformation> getProfessionalInformations(){
		logger.debug("service invoked for getting ProfessionalInformation");
		return professionalInformationRepository.findAll();
	}
	
	public Optional<ProfessionalInformation> getProfessionalInformationByInstituteName(String companyName){
		logger.debug("service invoked for getting ProfessionalInformation by name");
		return professionalInformationRepository.findByCompanyName(companyName);
	}
	
	public void deleteProfessionalInformation(ProfessionalInformation professionalInformation,String email){
logger.debug("service executed for deleting project");
		
		this.user=service.getUserByEmail(email);
		professionalInformations=professionalInformationRepository.findByCompanyNameAndExperience(professionalInformation.getCompanyName(), professionalInformation.getExperience());
		
		professionalInformations.stream().forEach(pro->{
			this.userProfessionalInformation=userProfessionalInformationRepository.findByUserIdAndProfessionalInformationId(this.user.getId(),pro.getId());
			
			logger.debug(userProfessionalInformation);
			this.optProfessionalInformation=professionalInformationRepository.findById(pro.getId());
			logger.debug(optProfessionalInformation);
			if(userProfessionalInformation!=null){
				if(optProfessionalInformation.isPresent()){
					this.professionalInformation=optProfessionalInformation.get();
				}
			}
			userProfessionalInformationRepository.delete(userProfessionalInformation);
			professionalInformationRepository.delete(this.professionalInformation);
		});
		
	}
	
}
