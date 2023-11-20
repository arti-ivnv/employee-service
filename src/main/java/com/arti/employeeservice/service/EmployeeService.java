package com.arti.employeeservice.service;

import org.springframework.stereotype.Service;

import com.arti.employeeservice.exceptions.EmployeeNotFoundException;
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

    public Employee one(Long id){
        return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public void add(Employee employee){
        repository.save(employee);
    }

    public Employee replaceEmployee(Employee newEmployee, Long id){
        return repository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            return repository.save(employee);
        })
        .orElseGet(() -> {
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
