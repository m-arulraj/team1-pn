package com.virtusa.registrationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.registrationapi.domain.User;

@Repository
public interface UserRegistrationRepository extends JpaRepository<User, Long> {

}
