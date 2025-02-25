package com.project.securityone.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "9Lr6Tg4pXQz9JtCj6lW9+VpWx5H7x5aR8J93FzqVj+E=";

    public String extractUserEmail(String token) {
        return extractClaim(token,claims -> claims.getSubject());
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token); // Get all claims (payload)
        return claimsResolver.apply(claims); // Extract the required claim
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignInKey()) // Set secret key for validation
                .build() // Build the parser
                .parseClaimsJws(token) // Decode and validate the JWT
                .getBody(); // Extract claims (payload)
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}

