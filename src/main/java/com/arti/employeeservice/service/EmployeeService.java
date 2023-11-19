package com.arti.employeeservice.service;

import org.springframework.stereotype.Service;

import com.arti.employeeservice.model.Employee;
import com.arti.employeeservice.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }


    public List<Employee> all(){
        return repository.findAll();
    }

}
