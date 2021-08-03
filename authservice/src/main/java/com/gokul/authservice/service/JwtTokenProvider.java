package com.gokul.authservice.service;


import com.gokul.authservice.config.JwtConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JwtTokenProvider {

    private final JwtConfig jwtConfig;

    public JwtTokenProvider(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(Authentication authentication){
        Long now=System.currentTimeMillis();
        log.warn("in generator");
        return Jwts.builder().setSubject(authentication.getName())
                .claim("authorities",authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now+jwtConfig.getExpiration()*1000))
                .signWith(SignatureAlgorithm.HS512,jwtConfig.getSecret().getBytes())
                .compact();
    }
}
