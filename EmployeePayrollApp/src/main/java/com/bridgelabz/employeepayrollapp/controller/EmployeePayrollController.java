package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.*;

/**
 * UC2: REST Controller demonstrating all HTTP methods for Employee Payroll.
 * At this stage, the focus is on controller connectivity and data transfer.
 */
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    /**
     * GET all employees
     */
    @GetMapping("/")
    public String getEmployees() {
        return "GET: Employee Payroll Service is running - returning all employees";
    }

    /**
     * GET employee by ID
     */
    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable long id) {
        return "GET: Fetching Employee with id: " + id;
    }

    /**
     * POST - create new employee
     */
    @PostMapping("/create")
    public String createEmployee(@RequestBody String employeeData) {
        return "POST: Creating Employee with data: " + employeeData;
    }

    /**
     * PUT - update employee
     */
    @PutMapping("/update")
    public String updateEmployee(@RequestBody String employeeData) {
        return "PUT: Updating Employee with data: " + employeeData;
    }

    /**
     * DELETE employee by ID
     */
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        return "DELETE: Deleting Employee with id: " + id;
    }
}
