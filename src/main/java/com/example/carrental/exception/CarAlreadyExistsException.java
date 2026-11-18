package com.example.carrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CarAlreadyExistsException extends RuntimeException {
    public CarAlreadyExistsException(String registrationNumber) {
        super("Car with registration number " + registrationNumber + " already exists");
    }
}
