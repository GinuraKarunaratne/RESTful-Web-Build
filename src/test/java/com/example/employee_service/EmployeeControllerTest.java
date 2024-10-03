package com.example.employee_service;

import com.example.employee_service.controller.EmployeeController;
import com.example.employee_service.model.Employee;
import com.example.employee_service.service.EmployeeManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeManager employeeManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee("1", "John", "Doe", "john.doe@example.com", "Developer");

        // Call the method you want to test (e.g., addEmployee)
        ResponseEntity<Employee> response = employeeController.addEmployee(employee);

        // Verify that the employeeManager.addEmployee method was called once
        verify(employeeManager, times(1)).addEmployee(employee);

        // Assert that the returned employee matches the created employee
        assertEquals(employee.getEmployeeId(), response.getBody().getEmployeeId());
        assertEquals(employee.getFirstName(), response.getBody().getFirstName());
        assertEquals(employee.getLastName(), response.getBody().getLastName());
        assertEquals(employee.getEmail(), response.getBody().getEmail());
        assertEquals(employee.getTitle(), response.getBody().getTitle());
    }

    @Test
    public void testGetEmployees() {
        Employee employee1 = new Employee("1", "John", "Doe", "john.doe@example.com", "Developer");
        Employee employee2 = new Employee("2", "Jane", "Doe", "jane.doe@example.com", "Manager");

        // Mocking the getEmployees method to return a list of employees
        when(employeeManager.getEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        // Call the method you want to test (e.g., getAllEmployees)
        List<Employee> response = employeeController.getAllEmployees();

        // Verify that the employeeManager.getEmployees method was called once
        verify(employeeManager, times(1)).getEmployees();

        // Assert that the returned list contains the correct employees
        assertEquals(2, response.size());
        assertEquals("John", response.get(0).getFirstName());
        assertEquals("Jane", response.get(1).getFirstName());
    }
}
