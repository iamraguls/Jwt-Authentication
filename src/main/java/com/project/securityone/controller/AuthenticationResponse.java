package com.project.securityone.controller;

import lombok.Builder;

@Builder
public class AuthenticationResponse {

    private String token;

    public AuthenticationResponse() {

    }

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
