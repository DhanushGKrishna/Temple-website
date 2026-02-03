package com.shiva.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminTestController{
	
	@GetMapping("/admin/test")
	public String test() {
		return "Admin API Accessed Successfully";
	}
}