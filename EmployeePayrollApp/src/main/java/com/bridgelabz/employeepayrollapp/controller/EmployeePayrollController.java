package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UC4: REST Controller with Service Layer injection.
 * All business logic is delegated to IEmployeePayrollService via @Autowired.
 */
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    /**
     * GET all employees
     */
    @GetMapping("/")
    public ResponseEntity<List<EmployeePayrollData>> getEmployees() {
        List<EmployeePayrollData> employees = employeePayrollService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    /**
     * GET employee by ID
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeeById(@PathVariable long id) {
        EmployeePayrollData employee = employeePayrollService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    /**
     * POST - create new employee (accepts DTO, returns model)
     */
    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollData> createEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData employee = employeePayrollService.createEmployee(employeeDTO);
        return ResponseEntity.ok(employee);
    }

    /**
     * PUT - update employee (accepts DTO, returns updated model)
     */
    @PutMapping("/update")
    public ResponseEntity<EmployeePayrollData> updateEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData updatedEmployee = employeePayrollService.updateEmployee(0L, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    /**
     * DELETE employee by ID
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        String message = employeePayrollService.deleteEmployee(id);
        return ResponseEntity.ok(message);
    }
}
