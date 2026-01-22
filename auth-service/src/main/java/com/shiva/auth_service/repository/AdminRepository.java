package com.shiva.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.shiva.auth_service.entity.Admin;

public interface AdminRepository extends JpaRepository <Admin, Long>{
	Optional<Admin> findByUsername(String username);
}