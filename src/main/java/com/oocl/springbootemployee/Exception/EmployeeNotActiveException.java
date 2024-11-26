package com.oocl.springbootemployee.Exception;

public class EmployeeNotActiveException extends IllegalArgumentException {
    public EmployeeNotActiveException() {
        super("Employee Not Active.");
    }
}
