package com.arti.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arti.employeeservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
