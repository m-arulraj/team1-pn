package com.professionalNetworking.postService.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	String based;
	String clients;
	String established;
	Long noofEmployees;
	String ceo;
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
	public String getBased() {
		return based;
	}
	public void setBased(String based) {
		this.based = based;
	}
	public String getClients() {
		return clients;
	}
	public void setClients(String clients) {
		this.clients = clients;
	}
	public String getEstablished() {
		return established;
	}
	public void setEstablished(String established) {
		this.established = established;
	}
	/*public Long getNoofEmployees() {
		return NoofEmployees;
	}
	public void setNoofEmployees(Long noofEmployees) {
		NoofEmployees = noofEmployees;
	}*/
	public String getCeo() {
		return ceo;
	}
	public Long getNoofEmployees() {
		return noofEmployees;
	}
	public void setNoofEmployees(Long noofEmployees) {
		this.noofEmployees = noofEmployees;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	
}
