package com.oocl.springbootemployee.controller;

import com.oocl.springbootemployee.Exception.CompanyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<String> handleCompanyNotFoundException(Exception ex) {
        return new ResponseEntity<>("EXCEPTION CAUGHT: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
