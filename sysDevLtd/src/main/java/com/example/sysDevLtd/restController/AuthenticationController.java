package com.example.sysDevLtd.restController;

import com.example.sysDevLtd.entity.request.AuthenticationRequest;
import com.example.sysDevLtd.entity.request.RegisterRequest;
import com.example.sysDevLtd.entity.response.AuthenticationResponse;
import com.example.sysDevLtd.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthenticationController {
@Autowired
 AuthenticationService service;
 @PostMapping("/register")
 public ResponseEntity<AuthenticationResponse> register(
         @RequestBody RegisterRequest request
 ) {
  return ResponseEntity.ok(service.register(request));
 }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }


}
