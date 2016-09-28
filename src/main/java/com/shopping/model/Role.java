package com.shopping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity//(name="user_roles")
public class Role {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String role;
	
	public Role(){
		
	}
	
	public Role(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
