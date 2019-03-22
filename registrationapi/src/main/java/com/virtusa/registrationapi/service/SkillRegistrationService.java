package com.virtusa.registrationapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.Skill;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.repository.SkillRegistrationRepository;

@Service
public class SkillRegistrationService {

	@Autowired
	SkillRegistrationRepository skillRegistrationRepository;
	@Autowired
	private UserRegistrationService service;
	
	static Logger logger=Logger.getLogger( SkillRegistrationService.class);

	public Skill saveSkill(Skill skill,String email) {
		
		logger.debug("service invoked for saving skill");
		
		//get User by email
		User user= service.getuserByEmail(email);
		
		logger.debug("got user based on email");
		
		//get all users of skill
		Set<User> users=new HashSet<User>();
		logger.debug("got users of skill");
		//add current user object to set of users for skill
		users.add(user);
		logger.debug("users of skill are:");
		users.stream().forEach(u->
		logger.debug(u.getEmail())
		);
		
		//add updated list of users to skill
		skill.setUsers(users);
		skill.getUsers().stream().forEach(u->logger.debug("user of skill->"+u.getEmail()));
		
		logger.debug("saving skill having users");
				
		return skillRegistrationRepository.save(skill);	
		
	}
		
	/*public Skill saveskill(Skill skill) {
		logger.debug("service invoked for saving skill");
		return skillRegistrationRepository.save(skill);
	}*/

	public Optional<Skill> getSkill(Long skillid) {
		logger.debug("service invoked for getting skill by id");
		return skillRegistrationRepository.findById(skillid);
	}
	
	public List<Skill> getSkills(){
		logger.debug("service invoked for getting skills");
		return skillRegistrationRepository.findAll();
	}
	
	public Optional<Skill> getSkillByName(String name){
		logger.debug("service invoked for getting skills by name");
		return skillRegistrationRepository.findByName(name);
	}

}
