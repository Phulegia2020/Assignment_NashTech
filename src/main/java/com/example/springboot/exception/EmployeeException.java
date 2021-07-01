package com.example.springboot.exception;

public class EmployeeException extends RuntimeException{
    public EmployeeException(long id)
    {
        super("Could not find employee with id = " + id);
    }
}
