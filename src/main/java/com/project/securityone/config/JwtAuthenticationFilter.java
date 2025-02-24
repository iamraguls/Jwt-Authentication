package com.project.securityone.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter { // OncePerRequestFilter => A special Spring Security filter that ensures each HTTP request is processed only once.

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        // when we pass a request, it will get a JWT token from the Authorization header
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        if(authHeader==null || !authHeader.startsWith("Bearer ")){ // authHeader always starts with Bearer nfe98u3h4ht42h79894h4h3r33g4w
            filterChain.doFilter(request,response);
            return;
        }

        // Remove "Bearer " prefix
        jwt = authHeader.substring(7);

        // extract the userEmail from jwt token
        userEmail = jwtService.extractUserEmail(jwt);


    }


}
