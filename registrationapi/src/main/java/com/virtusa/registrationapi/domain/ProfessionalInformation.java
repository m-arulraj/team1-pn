package com.virtusa.registrationapi.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="professional_info")
public class ProfessionalInformation {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="experince")
	private String expeience;
	
	@Column(name="technology")
	private String technology;
	
	@ManyToMany(mappedBy="skills")
	Set<User> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExpeience() {
		return expeience;
	}

	public void setExpeience(String expeience) {
		this.expeience = expeience;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
