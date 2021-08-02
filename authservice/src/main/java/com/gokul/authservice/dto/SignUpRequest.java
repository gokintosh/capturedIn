package com.gokul.authservice.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class SignUpRequest {

    @NotBlank
    @Size(min = 3,max = 30)
    private String name;

    @NotBlank
    @Size(min = 6,max = 15)
    private String username;

    @NotBlank
    @Size(min = 6,max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 8,max = 30)
    private String password;



}
