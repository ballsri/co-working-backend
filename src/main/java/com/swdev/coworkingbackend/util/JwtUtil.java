package com.swdev.coworkingbackend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration.minutes}")
    private int expiration;

    public String generateToken(String username, Map<String, String> claims) {
        return createToken(claims, username);
    }

    private String createToken(Map<String, String> claims, String subject) {
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expirationMillis = nowMillis + ((long) expiration *60  * 1000);
        Date expiration = new Date(expirationMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token, String username) {
        Claims claims = getClaims(token);
        return claims != null && claims.getSubject().equals(username);
    }

    public Claims getClaims(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(secret.getBytes());
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }
}


