package com.example.sysDevLtd.service;

import com.example.sysDevLtd.config.JwtService;
import com.example.sysDevLtd.entity.model.users.User;
import com.example.sysDevLtd.entity.model.users.token.Token;
import com.example.sysDevLtd.entity.model.users.token.TokenRepository;
import com.example.sysDevLtd.entity.model.users.token.TokenType;
import com.example.sysDevLtd.entity.request.AuthenticationRequest;
import com.example.sysDevLtd.entity.request.RegisterRequest;
import com.example.sysDevLtd.entity.response.AuthenticationResponse;
import com.example.sysDevLtd.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setUserName(request.getUserName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        this.saveUserToken(savedUser, jwtToken);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

//  public UserResponse registerUser(UserRegistrationDTO request) {
//    User objNewUser = new User();
//    objNewUser.setUserName(request.getUserName());
//    objNewUser.setPassword(passwordEncoder.encode(request.getPassword()));
//    objNewUser.setAssignedPrivilege(request.getAssignedPrivileges());
//    objNewUser.setRole(request.getRole());
//    objNewUser.setStatus(request.isUserStatus());
//
//    var savedUser = userRepository.save(objNewUser);
//    var jwtToken = jwtService.generateToken(objNewUser);
//    var refreshToken = jwtService.generateRefreshToken(objNewUser);
//    this.saveUserToken(savedUser, jwtToken);
//
//    return UserResponse.builder()
//            .accessToken(jwtToken)
//            .refreshToken(refreshToken)
//            .build();
//
//  }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();

    }


//  public UserResponse loginUser(UserDTO request) {
//    authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(
//                    request.getUserName(),
//                    request.getPassword()));
//    var user = userRepository.findByUserName(request.getUserName())
//            .orElseThrow();
//    var jwtToken = jwtService.generateToken(user);
//    var refreshToken = jwtService.generateRefreshToken(user);
//    revokeAllUserTokens(user);
//    saveUserToken(user, jwtToken);
//    return UserResponse.builder()
//            .accessToken(jwtToken)
//            .refreshToken(refreshToken)
//            .build();
//  }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
