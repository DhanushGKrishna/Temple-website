package com.shiva.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shiva.gateway.security.AuthenticationFilter;

@Configuration
public class GatewayRoutesConfig {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder,
	                           AuthenticationFilter authFilter) {

	    return builder.routes()

	        .route("auth-service", r -> r
	            .path("/api/auth/**")
	            .uri("http://localhost:8081"))

	        .route("admin-content", r -> r
	            .path("/api/admin/**")
	            .filters(f -> f.filter(authFilter))
	            .uri("http://localhost:8082"))

	        .route("public-content", r -> r
	            .path("/api/articles/**")
	            .uri("http://localhost:8082"))

	        .build();
	}

}
