package com.shiva.auth_service;

import org.springframework.boot.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.CommandLineRunner;
import com.shiva.auth_service.entity.Admin;
import com.shiva.auth_service.repository.AdminRepository;
import com.shiva.auth_service.config.*;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(AdminRepository repo, PasswordEncoder encoder) {
		return args -> {
			if(repo.findByUsername("admin").isEmpty()) {
				 Admin admin = new Admin();
		            admin.setUsername("admin");
		            admin.setPassword(encoder.encode("admin123"));
		            repo.save(admin);
			}
		};
	}
}
