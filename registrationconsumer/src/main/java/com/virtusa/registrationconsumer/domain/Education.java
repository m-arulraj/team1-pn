package com.virtusa.registrationconsumer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String highschool;
	String intermediate;
	String graduation;
	String postgraduation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHighschool() {
		return highschool;
	}
	public void setHighschool(String highschool) {
		this.highschool = highschool;
	}
	public String getIntermediate() {
		return intermediate;
	}
	public void setIntermediate(String intermediate) {
		this.intermediate = intermediate;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	public String getPostgraduation() {
		return postgraduation;
	}
	public void setPostgraduation(String postgraduation) {
		this.postgraduation = postgraduation;
	}
	
	
}
