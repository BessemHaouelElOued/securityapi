package com.lcs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class DefinedRoles {
	
	@Id
	@GeneratedValue
	int id;
	
	String role;
	String description;
	
	@ManyToOne
	@JsonBackReference
	Lcsapp app;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Lcsapp getApp() {
		return app;
	}

	public void setApp(Lcsapp app) {
		this.app = app;
	}
	

}
