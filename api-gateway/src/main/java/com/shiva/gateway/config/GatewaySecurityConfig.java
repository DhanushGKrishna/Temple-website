package com.shiva.gateway.config;

import org.springframework.context.annotation.Bean;

import org.springframework.http.HttpMethod;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import com.shiva.gateway.security.AuthenticationFilter;

import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.authentication.ReactiveAuthenticationManager;


@Configuration
@EnableWebFluxSecurity
public class GatewaySecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
            // Disable CSRF (stateless APIs)
            .csrf(ServerHttpSecurity.CsrfSpec::disable)

            // Disable default login/security mechanisms
            .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
            .formLogin(ServerHttpSecurity.FormLoginSpec::disable)

            // Authorization rules
            .authorizeExchange(ex -> ex
                // ✅ Auth service (login, signup)
                .pathMatchers("/api/auth/**").permitAll()

                // ✅ Public article APIs
                .pathMatchers(HttpMethod.GET, "/api/articles/**").permitAll()

                // 🔒 Admin APIs (JWT required)
                .pathMatchers("/api/admin/**").authenticated()

                // 🔒 Everything else needs JWT
                .anyExchange().authenticated()
            )

            .build();
    }
}





