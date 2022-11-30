package com.spring.gradle.defect.Exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleWrongInput(NoSuchElementException noSuchElementException){
        return new ResponseEntity<String>("Check your inputs", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String>handleWrongInput(EmptyResultDataAccessException emptyResultDataAccessException){
        return new ResponseEntity<String>("No such element in database", HttpStatus.NOT_FOUND);
    }
}
