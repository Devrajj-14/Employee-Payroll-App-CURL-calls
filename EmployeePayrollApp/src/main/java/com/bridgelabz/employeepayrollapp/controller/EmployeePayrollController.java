package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * UC3: REST Controller updated to use EmployeePayrollDTO and EmployeePayrollData model.
 * The controller now handles DTO as input and returns model-based responses.
 */
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    /**
     * GET all employees - returns a simple list demonstrating model usage
     */
    @GetMapping("/")
    public ResponseEntity<List<EmployeePayrollData>> getEmployees() {
        List<EmployeePayrollData> employees = new ArrayList<>();
        employees.add(new EmployeePayrollData(1L, "Sample Employee", 50000.0));
        return ResponseEntity.ok(employees);
    }

    /**
     * GET employee by ID
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeeById(@PathVariable long id) {
        EmployeePayrollData employee = new EmployeePayrollData(id, "Sample Employee " + id, 50000.0);
        return ResponseEntity.ok(employee);
    }

    /**
     * POST - create new employee (accepts DTO, returns model)
     */
    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollData> createEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData employee = new EmployeePayrollData(1L, employeeDTO.getName(), employeeDTO.getSalary());
        return ResponseEntity.ok(employee);
    }

    /**
     * PUT - update employee (accepts DTO, returns updated model)
     */
    @PutMapping("/update")
    public ResponseEntity<EmployeePayrollData> updateEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData updatedEmployee = new EmployeePayrollData(1L, employeeDTO.getName(), employeeDTO.getSalary());
        return ResponseEntity.ok(updatedEmployee);
    }

    /**
     * DELETE employee by ID
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        return ResponseEntity.ok("Employee with id " + id + " deleted successfully");
    }
}
