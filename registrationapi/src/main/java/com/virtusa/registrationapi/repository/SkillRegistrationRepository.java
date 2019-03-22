package com.virtusa.registrationapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.registrationapi.domain.Skill;

@Repository
public interface SkillRegistrationRepository extends JpaRepository<Skill, Long> {

	public Optional<Skill> findByName(String name);
}
