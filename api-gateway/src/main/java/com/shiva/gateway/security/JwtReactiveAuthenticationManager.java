package com.shiva.gateway.security;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component  // 🔴 THIS IS REQUIRED
public class JwtReactiveAuthenticationManager
        implements ReactiveAuthenticationManager {

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        // JWT validation logic
        return Mono.just(authentication);
    }
}
