package com.shiva.auth_service.dto;

import lombok.Data;

@Data
public class LoginRequest{
	private String username;
	private String password;
	
	//getter and setter
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassowrd(String password) {
		this.password = password;
	}
}