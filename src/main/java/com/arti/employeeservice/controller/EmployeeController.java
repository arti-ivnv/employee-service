package com.arti.employeeservice.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arti.employeeservice.model.Employee;
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
    public List<Employee> allEmployees(){
        return service.all();
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee newEmployee){
        service.add(newEmployee);
    }

    @GetMapping("/{id}")
    public EntityModel<Employee> oneEmployee(@PathVariable Long id){
        return service.one(id);
    }

    @PutMapping
    public Employee replaceEmployee(@RequestBody Employee newEmployee, Long id){
        return service.replaceEmployee(newEmployee, id);
    }

    @DeleteMapping
    public void deleteEmployee(Long id){
        service.delete(id);
    }

}
