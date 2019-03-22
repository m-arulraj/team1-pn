package com.virtusa.registrationapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.registrationapi.domain.Certificate;

@Repository
public interface CertificateRegistrationRepository  extends JpaRepository<Certificate, Long> {

	public Optional<Certificate> findByInstituteName(String name);
}
