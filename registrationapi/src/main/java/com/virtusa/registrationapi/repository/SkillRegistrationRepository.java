package com.virtusa.registrationapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.registrationapi.domain.Skill;

@Repository
public interface SkillRegistrationRepository extends JpaRepository<Skill, Long> {

	public Skill findByName(String name);
}
