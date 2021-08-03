package com.gokul.authservice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class JwtAuthenticationResponse {

    @NotNull
    private String accessToken;
    private String tokenType="Bearer";


    public JwtAuthenticationResponse(String jwt) {
        accessToken=jwt;
    }
}
