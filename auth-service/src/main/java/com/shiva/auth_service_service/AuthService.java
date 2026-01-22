package com.shiva.auth_service_service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shiva.auth_service_dto.LoginRequest;
import com.shiva.auth_service.entity.Admin;
import com.shiva.auth_service.repository.AdminRepository;
import com.shiva.auth_service.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService{
	private final AdminRepository adminRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;
	
	
	public AuthService(AdminRepository adminRepository,
			PasswordEncoder passwordEncoder,
			JwtUtil jwtUtil) {
		this.adminRepository = adminRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}
	
	public String login(LoginRequest request) {
		Admin admin = adminRepository.findByUsername(request.getUsername())
				.orElseThrow(()-> new RuntimeException("Invalid Username"));
		
		
		if(!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
			throw new RuntimeException("Invalid Password");
		}
		
		return jwtUtil.generateToken(admin.getUsername());
		
	}
}

