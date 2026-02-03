package com.shiva.gateway.security;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtUtil{
	private static final String SECRET = "temple-secret-key";
	
	public static Claims validateToken(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token)
				.getBody();
	}
	
	public static boolean isExpired(Claims claims) {
		return claims.getExpiration().before(new Date());
	}
}