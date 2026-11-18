package com.example.carrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCarException extends RuntimeException {
    public InvalidCarException(String message) {
        super(message);
    }
}
