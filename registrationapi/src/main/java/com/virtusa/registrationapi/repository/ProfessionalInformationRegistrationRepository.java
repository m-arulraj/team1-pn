package com.virtusa.registrationapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.registrationapi.domain.ProfessionalInformation;

@Repository
public interface ProfessionalInformationRegistrationRepository extends JpaRepository<ProfessionalInformation, Long>{

	public Optional<ProfessionalInformation> findByCompanyName(String name);
	public List<ProfessionalInformation> findByCompanyNameAndExperience(String name,String experience);
}
