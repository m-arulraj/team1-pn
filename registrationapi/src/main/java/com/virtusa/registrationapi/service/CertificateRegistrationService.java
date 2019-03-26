package com.virtusa.registrationapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.Certificate;
import com.virtusa.registrationapi.domain.Skill;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.domain.UserCertificate;
import com.virtusa.registrationapi.repository.CertificateRegistrationRepository;
import com.virtusa.registrationapi.repository.UserCertificateRepository;

@Service
public class CertificateRegistrationService {

	@Autowired
	CertificateRegistrationRepository certificateRegistrationRepository;
	@Autowired
	UserCertificateRepository userCertificateRepository;
	@Autowired
	private UserRegistrationService service;
	
	static Logger logger=Logger.getLogger( CertificateRegistrationService.class);

public Certificate saveCertificate(Certificate certificate,String email) {
		
		logger.debug("service invoked for saving Certificate");
		
		//get User by email
		User user= service.getuserByEmail(email);
		
		logger.debug("got user based on email");
		
		//get all users of Certificate
		Set<User> users=new HashSet<User>();
		logger.debug("got users of Certificate");
		//add current user object to set of users for Certificate
		users.add(user);
		logger.debug("users of Certificate are:");
		users.stream().forEach(u->
		logger.debug(u.getEmail())
		);
		
		//add updated list of users to Certificate
		certificate.setUsers(users);
		certificate.getUsers().stream().forEach(u->logger.debug("user of Certificate->"+u.getEmail()));
		
		logger.debug("saving skill having users");
				
		certificate=certificateRegistrationRepository.save(certificate);
		
		UserCertificate userCertificate= new UserCertificate();
		userCertificate.setCertificateId(certificate.getId());
		userCertificate.setUserId(user.getId());
		
		//save user skill
		userCertificateRepository.save(userCertificate);
		
		return certificate;
		
	}
		

	public Optional<Certificate> getCertificate(Long certificateId) {
		logger.debug("service invoked for getting Certificate by id");
		return certificateRegistrationRepository.findById(certificateId);
	}
	
	public List<Certificate> getCertificates(){
		logger.debug("service invoked for getting Certificate");
		return certificateRegistrationRepository.findAll();
	}
	
	public List<Optional<Certificate>> getCertificateByInstituteName(String instituteName){
		logger.debug("service invoked for getting Certificate by name");
		return certificateRegistrationRepository.findByInstituteName(instituteName);
	}
}
