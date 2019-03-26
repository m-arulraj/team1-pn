package com.virtusa.registrationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.registrationapi.domain.UserProject;

@Repository
public interface UserProjectRepository extends JpaRepository<UserProject, Long> {

}
