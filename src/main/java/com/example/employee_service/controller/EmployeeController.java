package com.example.employee_service.controller;

import com.example.employee_service.model.Employee;
import com.example.employee_service.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    // GET request to retrieve all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeManager.getEmployees();
    }

    // POST request to add a new employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeManager.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
}
