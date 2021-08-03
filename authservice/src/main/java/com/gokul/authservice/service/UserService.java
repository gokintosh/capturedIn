package com.gokul.authservice.service;

import com.gokul.authservice.exceptions.EmailAlreadyExistException;
import com.gokul.authservice.exceptions.UsernameAlreadyExistException;
import com.gokul.authservice.model.Role;
import com.gokul.authservice.model.User;
import com.gokul.authservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByUsername(String username) {
        log.info("retrieving user {}", username);
        return userRepository.findByUsername(username);
    }

    public User registerUser(User user){
        log.info("registering user {}",user.getUsername());

        if(userRepository.existsByUsername(user.getUsername())){
            log.warn("username {} already exists",user.getUsername());

            throw new UsernameAlreadyExistException(String.format("username %s already exists",user.getUsername()));
        }

        if(userRepository.existsByEmail(user.getEmail())){
            log.warn("email {} already exists",user.getEmail());

            throw new EmailAlreadyExistException(String.format("email %s already exists",user.getEmail()));
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(){{
            add(Role.USER);
        }});


        User saveUser=userRepository.save(user);

        return saveUser;
    }
}
