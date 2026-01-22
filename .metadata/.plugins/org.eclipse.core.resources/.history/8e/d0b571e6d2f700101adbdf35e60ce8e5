package com.shiva.auth_service_controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shiva.auth_service_dto.LoginRequest;
import com.shiva.auth_service_dto.LoginResponse;
import com.shiva.auth_service_service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
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