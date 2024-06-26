package com.example.nibbsdemoproject.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
