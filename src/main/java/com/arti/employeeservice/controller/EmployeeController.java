package com.arti.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arti.employeeservice.model.Employee;
import com.arti.employeeservice.repository.EmployeeRepository;
import com.arti.employeeservice.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    private final EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @GetMapping
    public List<Employee> all(){
        return service.all();
    }
}
