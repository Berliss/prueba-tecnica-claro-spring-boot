package com.bersoft.crudapplication.model.exception;

public class MyEmployeeNotFoundException extends RuntimeException{
    public MyEmployeeNotFoundException( Long id) {
        super("Employee with ID -> " + id + " not found");
    }
}
