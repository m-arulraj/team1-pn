package com.virtusa.registrationapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.registrationapi.domain.User;

@Repository
public interface UserRegistrationRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);
	public User findByPhone(Long phone);
	public List<User> findByName(String name);
	

	public List<User> findByNameContainingIgnoreCase(String name);
	
	
}
