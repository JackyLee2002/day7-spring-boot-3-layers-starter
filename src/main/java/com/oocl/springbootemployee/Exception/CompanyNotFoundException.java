package com.oocl.springbootemployee.Exception;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException() {
        super("Company Not Found.");
    }
}
