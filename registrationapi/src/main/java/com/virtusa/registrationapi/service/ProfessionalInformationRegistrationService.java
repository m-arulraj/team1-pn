package com.virtusa.registrationapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.ProfessionalInformation;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.repository.ProfessionalInformationRegistrationRepository;

@Service
public class ProfessionalInformationRegistrationService {

	@Autowired
	ProfessionalInformationRegistrationRepository professionalInformationRepository;
	@Autowired
	private UserRegistrationService service;
	
	static Logger logger=Logger.getLogger(ProfessionalInformationRegistrationService.class);
	
	
public ProfessionalInformation saveProfessionalInformation(ProfessionalInformation professionalInformation,String email) {
		
		logger.debug("service invoked for saving ProfessionalInformation");
		
		//get User by email
		User user= service.getuserByEmail(email);
		
		logger.debug("got user based on email");
		
		//get all users of ProfessionalInformation
		Set<User> users=new HashSet<User>();
		logger.debug("got users of ProfessionalInformation");
		//add current user object to set of users for ProfessionalInformation
		users.add(user);
		
		logger.debug("users of ProfessionalInformation are:");
		users.stream().forEach(u->
		
		logger.debug(u.getEmail())
		);
		
		//add updated list of users to ProfessionalInformation
		professionalInformation.setUsers(users);
		professionalInformation.getUsers().stream().forEach(u->logger.debug("user of ProfessionalInformation->"+u.getEmail()));
		
		logger.debug("saving ProfessionalInformation having users");
				
		return professionalInformationRepository.save(professionalInformation);	
		
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
}
