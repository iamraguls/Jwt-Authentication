package com.project.securityone.config;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String extractUserEmail(String jwt) {
        return null;
    }

    private Claims extractAllClaims(String token){

    }

}
