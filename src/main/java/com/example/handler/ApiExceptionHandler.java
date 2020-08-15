package com.example.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.model.ErrorResponse;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleApiException(
    		Exception ex) {
        ErrorResponse response = 
            new ErrorResponse("999",ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    } 

}
