package com.example.sysDevLtd.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class CustomAuthentication extends UsernamePasswordAuthenticationToken {

    private String role;

    public CustomAuthentication() {
        super("anonymous", "anonymous", null); // Default values for principal, credentials, and authorities
    }

    public CustomAuthentication(Authentication authentication) {
        super(authentication.getPrincipal(), authentication.getCredentials(), authentication.getAuthorities());
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

