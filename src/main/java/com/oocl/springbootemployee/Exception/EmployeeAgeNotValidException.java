package com.oocl.springbootemployee.Exception;

public class EmployeeAgeNotValidException extends IllegalArgumentException {
    public EmployeeAgeNotValidException() {
        super("Invalid Age for Employee.");
    }
}
