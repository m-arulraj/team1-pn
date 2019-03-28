package com.virtusa.registrationapi.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.virtusa.registrationapi.domain.UserSkill;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill,Long> {

	public UserSkill findByUserIdAndSkillId(Long userId,Long skillId);
}
