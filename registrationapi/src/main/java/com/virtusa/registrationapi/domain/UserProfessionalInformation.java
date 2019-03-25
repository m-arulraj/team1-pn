package com.virtusa.registrationapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_professional_info")
public class UserProfessionalInformation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="prof_id")
	private Long professionalInformationId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProfessionalInformationId() {
		return professionalInformationId;
	}

	public void setProfessionalInformationId(Long professionalInformationId) {
		this.professionalInformationId = professionalInformationId;
	}
}
