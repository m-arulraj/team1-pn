package com.virtusa.registrationapi.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Long id;
	@Column(name="name")
	String name;
	@Column(name="email")
	String email;
	@Column(name="dob")
	String dob;
	@Column(name="phone")
	Long phone;
	@Column(name="gender")
	String gender;
	@Column(name="country")
	String country;
	@Column(name="state")
	String state;
	@Column(name="password")
	String password;

	@OneToOne()
	@JoinColumn(name="education_id")
	Education education;
	
	@ManyToMany(cascade = { CascadeType.ALL },fetch=FetchType.EAGER)
	 @JoinTable(
		        name = "user_skill", 
		        joinColumns = { @JoinColumn(name = "user_id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "skill_id") }
		    )
	Set<Skill> skills;
	
	@ManyToMany(cascade = { CascadeType.ALL },fetch=FetchType.EAGER)
	 @JoinTable(
		        name = "user_project", 
		        joinColumns = { @JoinColumn(name = "user_id") }, 
		        inverseJoinColumns = { @JoinColumn(name = "project_id") }
		    )
	
	Set<Project> projects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
