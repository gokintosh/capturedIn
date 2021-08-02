package com.gokul.authservice.exceptions;

public class UsernameAlreadyExistException extends RuntimeException{
    public UsernameAlreadyExistException(String message) {
        super(message);
    }
}
