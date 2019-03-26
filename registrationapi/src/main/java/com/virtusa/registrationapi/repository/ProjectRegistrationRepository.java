package com.virtusa.registrationapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.registrationapi.domain.Project;


@Repository
public interface ProjectRegistrationRepository extends JpaRepository<Project, Long> {

	public Optional<Project> findByType(String name);
	public List<Project> findByTypeAndRole(String type, String role);
}
