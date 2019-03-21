package com.virtusa.registrationapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.Skill;
import com.virtusa.registrationapi.repository.SkillRegistrationRepository;

@Service
public class SkillRegistrationService {

	@Autowired
	SkillRegistrationRepository skillRegistrationRepository;

	public Skill saveskill(Skill skill) {
		return skillRegistrationRepository.save(skill);

	}

	public Optional<Skill> getallskills(Long skillid) {
		return skillRegistrationRepository.findById(skillid);
	}

}
