package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

/**
 * UC4: Service interface for Employee Payroll operations.
 * Defines the contract for business logic layer.
 */
public interface IEmployeePayrollService {

    /**
     * Get all employees
     */
    List<EmployeePayrollData> getAllEmployees();

    /**
     * Get employee by ID
     */
    EmployeePayrollData getEmployeeById(long employeeId);

    /**
     * Create a new employee from DTO
     */
    EmployeePayrollData createEmployee(EmployeePayrollDTO employeeDTO);

    /**
     * Update an existing employee from DTO
     */
    EmployeePayrollData updateEmployee(long employeeId, EmployeePayrollDTO employeeDTO);

    /**
     * Delete employee by ID
     */
    String deleteEmployee(long employeeId);
}
