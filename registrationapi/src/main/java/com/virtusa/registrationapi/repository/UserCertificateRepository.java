package com.virtusa.registrationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.registrationapi.domain.UserCertificate;

public interface UserCertificateRepository extends JpaRepository<UserCertificate, Long>  {

}
