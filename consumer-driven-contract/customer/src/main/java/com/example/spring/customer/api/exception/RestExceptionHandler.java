package com.example.spring.customer.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    private MediaType errorMediaType = MediaType.valueOf("application/vnd.error+json");


    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<String> notFoundException(NotFoundException ex) {
       return ResponseEntity.status(HttpStatus.NOT_FOUND).
               contentType(errorMediaType).
               body(ex.getMessage());
    }

}
