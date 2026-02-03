package com.shiva.gateway.security;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

import com.shiva.gateway.security.JwtUtil;

@Component
public class AuthenticationFilter implements WebFilter{
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain){
	ServerHttpRequest request = exchange.getRequest();
	String path = request.getURI().getPath();
	
	//Allow public endpoints
	
	if (path.startsWith("/api/auth")) {
		return chain.filter(exchange);
	}
	
	if(!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
		exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
		return exchange.getResponse().setComplete();
	}
	
	String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
	
	if(authHeader == null || !authHeader.startsWith("Bearer ")) {
		exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
		return exchange.getResponse().setComplete();
	}
	
	String token = authHeader.substring(7);
	
	try {
		Claims claims = JwtUtil.validateToken(token);
		
		if(JwtUtil.isExpired(claims)) {
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			return exchange.getResponse().setComplete();
		}
	} catch (Exception e) {
		exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
		return exchange.getResponse().setComplete();
	}
	
	return chain.filter(exchange);
	}
}
	


