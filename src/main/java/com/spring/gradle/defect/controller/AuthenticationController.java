package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.Security.CustomUserDetails;
import com.spring.gradle.defect.Security.JWTUtility;
import com.spring.gradle.defect.dto.AuthResponseDto;
import com.spring.gradle.defect.dto.AuthenticationDto;
import com.spring.gradle.defect.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetails customUserDetails;
    @Autowired
    private JWTUtility jwtUtility;

    @PostMapping("/login")
    public ResponseEntity<Object> createAuthToken(@RequestBody AuthenticationDto authenticationDto) throws Exception {

        try {
            Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDto.getUsername(),
                    authenticationDto.getPassword()));
            User user= (User) authentication.getPrincipal();
            final String jwt = jwtUtility.generateAccessToken(user);
            
            return ResponseEntity.ok().body(new AuthResponseDto(jwt));

        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials");
        }


    }
}
