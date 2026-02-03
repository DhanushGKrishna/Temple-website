package com.shiva.auth_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.shiva.auth_service.repository.*;

@Configuration
public class ApplicationConfig{
	private final AdminRepository adminRepository;
	
	public ApplicationConfig(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return username ->adminRepository.findByUsername(username)
				.orElseThrow(() ->
						new UsernameNotFoundException("Admin not found"));
	}
	
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
