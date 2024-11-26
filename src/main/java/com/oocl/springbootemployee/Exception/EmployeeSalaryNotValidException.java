package com.oocl.springbootemployee.Exception;

public class EmployeeSalaryNotValidException extends IllegalArgumentException {
    public EmployeeSalaryNotValidException() {
        super("Invalid Salary For Employee aged 30 or above.");
    }
}
