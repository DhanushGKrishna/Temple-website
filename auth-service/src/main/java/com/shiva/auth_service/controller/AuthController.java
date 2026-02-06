package com.shiva.auth_service.controller;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.shiva.auth_service.dto.LoginRequest;
import com.shiva.auth_service.dto.LoginResponse;
import com.shiva.auth_service.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
public class AuthController{
	
	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
		String token = authService.login(request);
		return ResponseEntity.ok(new LoginResponse(token));
		
	}
}