package com.arti.employeeservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.arti.employeeservice.exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeNotFoundAdvice {
    
    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(EmployeeNotFoundException ex){
        return ex.getMessage();
    }
}
