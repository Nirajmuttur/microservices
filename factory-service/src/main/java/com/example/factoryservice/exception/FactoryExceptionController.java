package com.example.factoryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FactoryExceptionController {
    @ExceptionHandler(value = FactoryNotFoundException.class)
    public ResponseEntity<Object> exception(FactoryNotFoundException exception){
        return new ResponseEntity<>("Factory not found", HttpStatus.NOT_FOUND);
    }
}
