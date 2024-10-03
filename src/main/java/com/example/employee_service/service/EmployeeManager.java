package com.example.employee_service.service;

import com.example.employee_service.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeManager {

    private List<Employee> employees = new ArrayList<>();

    // Existing code for hard-coded employees...

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}
