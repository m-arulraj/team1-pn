package com.virtusa.professionalnetworking.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Skill {

	@Id
	@GeneratedValue
	Long id;
	
	String name;
}
