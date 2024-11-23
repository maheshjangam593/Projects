package com.example.controller;

import com.example.dto.AuthRequest;
import com.example.entity.UserCredential;
import com.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class Controller {

    @Autowired
    private AuthService authService;


    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserCredential userCredential) {

        return authService.saveUser(userCredential);
    }
    // need to provide token for only previous register users means who are authenticated already
    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest)
    {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authenticate.isAuthenticated())
        {
           return authService.getToken(authRequest.getUsername());
        }
        else {
            throw new RuntimeException("invalid access");
        }

    }
    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        return authService.validateToken(token);

    }
}



