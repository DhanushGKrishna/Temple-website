package com.shiva.auth_service_dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse{
	private String token;
	
	public LoginResponse(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
}