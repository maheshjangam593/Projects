package com.example.service;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;

@Component
public class JwtService {

    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    public String generateToken(String userName) {


        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getApiKeys(), SignatureAlgorithm.HS256).compact();
    }

    private Key getApiKeys() {
        byte[] byteKeys = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(byteKeys);
    }

    public void validateToken(String token) {
        Jwts.parserBuilder().setSigningKey(getApiKeys()).build().parseClaimsJws(token);

    }
}
