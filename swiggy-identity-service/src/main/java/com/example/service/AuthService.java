package com.example.service;

import com.example.entity.UserCredential;
import com.example.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private JwtService jwtService;
    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        userDetailsRepository.save(credential);
        return "user added to the system";
    }

    public String getToken(String username) {

        return jwtService.generateToken(username);
    }

    public String validateToken(String token) {
        jwtService.validateToken(token);
        return "Token is valid";
    }
}
