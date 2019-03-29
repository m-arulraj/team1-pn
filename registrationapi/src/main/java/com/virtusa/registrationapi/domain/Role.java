package com.virtusa.registrationapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
@Entity
@Table(name="Role")*/
public class Role {

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;*/
	
	@Column(name="role_name")
	String roleName;
	


	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
}
