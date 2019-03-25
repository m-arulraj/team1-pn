package com.virtusa.registrationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.registrationapi.domain.UserProfessionalInformation;

public interface UserProfessionalInformationRepository extends JpaRepository<UserProfessionalInformation, Long> {

}
