package com.example.pack.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
        
        private static final String SECRET = "your-256-bit-secret-key-your-256-bit-secret-key";

        private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

        public String generateToken(UserDetails user) {
                return Jwts.builder()
                        .subject(user.getUsername())
                        .issuedAt(new Date())
                        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                        .signWith(key)
                        .compact();
        }

        public String extractUsername(String token){
                return Jwts.parser()
                        .verifyWith((SecretKey) key)
                        .build()
                        .parseSignedClaims(token)
                        .getPayload()
                        .getSubject();
        }

        public boolean isTokenValid(String token, UserDetails user) {
                return extractUsername(token).equals(user.getUsername())
                        && !isExpired(token);
        }

        public boolean isExpired(String token) {
                Date expiration = Jwts.parser()
                        .verifyWith((SecretKey) key)
                        .build()
                        .parseSignedClaims(token)
                        .getPayload()
                        .getExpiration();

                return expiration.before(new Date());
                
        }

}
