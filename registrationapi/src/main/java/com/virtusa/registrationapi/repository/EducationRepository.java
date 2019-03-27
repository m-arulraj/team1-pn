package com.virtusa.registrationapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.registrationapi.domain.Education;
import com.virtusa.registrationapi.domain.User;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
	
	public Optional<Education> findByUser(User user);
	public void deleteByUser(User user);
	
	@Modifying
	@Query(value="delete from Education edu where edu.id=?1")
	public void deleteById(Long id);
}
