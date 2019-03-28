package com.virtusa.registrationapi.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.registrationapi.domain.Skill;
import com.virtusa.registrationapi.domain.User;
import com.virtusa.registrationapi.domain.UserSkill;
import com.virtusa.registrationapi.repository.SkillRegistrationRepository;
import com.virtusa.registrationapi.repository.UserSkillRepository;

@Service
public class SkillRegistrationService {

	@Autowired
	SkillRegistrationRepository skillRegistrationRepository;
	
	@Autowired
	UserSkillRepository userSkillRepository;
	
	@Autowired
	private UserRegistrationService service;
	
	public User user;
	public Skill skill;
	
	static Logger logger=Logger.getLogger( SkillRegistrationService.class);

	public Skill saveSkill(Skill skill,String email) {
		
		logger.debug("service invoked for saving skill");
		
		//get User by email
		User user= service.getUserByEmail(email);
		
		logger.debug("got user based on email");
		this.skill=skillRegistrationRepository.findByName(skill.getName());
		
		if(this.skill!=null){
			logger.debug("got existing skill object");
			user.getSkills().add(this.skill);
			this.skill.getUsers().add(user);
			
			service.saveUser(user);
			return this.skill;
		}else{
			logger.debug("did not get existing skill object");
			this.skill= new Skill();
			logger.debug("input name for skill->"+skill.getName());
			this.skill.setName(skill.getName());
			user.getSkills().add(this.skill);
			//this.skill.getUsers().add(user);
			
			service.saveUser(user);
			return this.skill;
		}
	}

	public Optional<Skill> getSkill(Long skillid) {
		logger.debug("service invoked for getting skill by id");
		return skillRegistrationRepository.findById(skillid);
	}
	
	public List<Skill> getSkills(){
		logger.debug("service invoked for getting skills");
		return skillRegistrationRepository.findAll();
	}
	
	public Skill getSkillByName(String name){
		logger.debug("service invoked for getting skills by name");
		return skillRegistrationRepository.findByName(name);
	}
	
	public int deleteSkill(Skill skill,String email){
		this.skill=getSkillByName(skill.getName());
		this.user=service.getUserByEmail(email);
		
		this.user.getSkills().stream().forEach(sk->{
		if(sk.getName().equals(this.skill.getName())){
			
			UserSkill userSkill=userSkillRepository.findByUserIdAndSkillId(this.user.getId(), this.skill.getId());
			userSkillRepository.delete(userSkill);
		}
		});
		if(this.user.getSkills().contains(this.skill)){
			return 0;
		}else{
			return 1;
		}
	}
}
