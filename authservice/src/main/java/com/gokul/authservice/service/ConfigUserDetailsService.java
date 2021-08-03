package com.gokul.authservice.service;

import com.gokul.authservice.model.CapturedInUserdeails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConfigUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userService
                .findByUsername(s)
                .map(CapturedInUserdeails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
