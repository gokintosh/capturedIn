package com.gokul.authservice.exceptions;

public class EmailAlreadyExistException extends RuntimeException{
    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
