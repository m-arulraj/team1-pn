package com.virtusa.registrationconsumer.domain;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private String roleName;

	

	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public String getAuthority() {
		return this.roleName;
	}
}