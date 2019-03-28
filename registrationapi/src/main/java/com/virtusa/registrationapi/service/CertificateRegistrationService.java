package com.virtusa.registrationapi.service;


import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.Certificate;
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
	
	public User user;
	List<Certificate> certificates;
	UserCertificate userCertificate;
	Optional<Certificate> optcertificate;
	Certificate certificate;
	
	static Logger logger=Logger.getLogger( CertificateRegistrationService.class);

public Certificate saveCertificate(Certificate certificate,String email) {
		
		logger.debug("service invoked for saving Certificate");
		
		//get User by email
		User user= service.getUserByEmail(email);
		
		logger.debug("got user based on email");
		
		user.getCertificates().add(certificate);
		service.saveUser(user);
		
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
	
	public List<Certificate> getCertificateByInstituteName(String instituteName){
		logger.debug("service invoked for getting Certificate by name");
		return certificateRegistrationRepository.findByInstituteName(instituteName);
	}
	
	public void deleteCertificate(Certificate certificate,String email){
		logger.debug("service executed for deleting certificate");
		this.user=service.getUserByEmail(email);
		this.certificates=certificateRegistrationRepository.findByInstituteName(certificate.getInstituteName());
		
		certificates.stream().forEach(cert->{
			this.userCertificate=userCertificateRepository.findByUserIdAndCertificateId(this.user.getId(), cert.getId());
			logger.debug(userCertificate);
			this.optcertificate=certificateRegistrationRepository.findById(cert.getId());
			logger.debug(optcertificate);
			if(userCertificate!=null){
				if(optcertificate.isPresent()){
					this.certificate=optcertificate.get();
				}
			}
			userCertificateRepository.delete(userCertificate);
			certificateRegistrationRepository.delete(this.certificate);
		});
	}
}
