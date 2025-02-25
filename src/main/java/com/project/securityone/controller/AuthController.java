package com.project.securityone.controller;

import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/register")
    public RequestEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){

    }

    @PostMapping("/authenticate")
    public RequestEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){

    }


}
