package com.example.employee_service;

public class EmployeeManager {
    private Employees employees;

    public EmployeeManager() {
        employees = new Employees();
        initializeEmployees();
    }

    // Hard-code example employees
    private void initializeEmployees() {
        employees.addEmployee(new Employee("1", "John", "Doe", "john.doe@example.com", "Developer"));
        employees.addEmployee(new Employee("2", "Jane", "Smith", "jane.smith@example.com", "Manager"));
        employees.addEmployee(new Employee("3", "Alice", "Johnson", "alice.johnson@example.com", "Designer"));
    }

    // Getter for employees
    public Employees getEmployees() {
        return employees;
    }
}
