package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UC4: Service implementation for Employee Payroll.
 * Contains business logic, delegated from the controller.
 * Storage will be enhanced in UC5 with local list.
 */
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        List<EmployeePayrollData> employees = new ArrayList<>();
        employees.add(new EmployeePayrollData(1L, "Sample Employee", 50000.0));
        return employees;
    }

    @Override
    public EmployeePayrollData getEmployeeById(long employeeId) {
        return new EmployeePayrollData(employeeId, "Sample Employee " + employeeId, 50000.0);
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO employeeDTO) {
        return new EmployeePayrollData(1L, employeeDTO.getName(), employeeDTO.getSalary());
    }

    @Override
    public EmployeePayrollData updateEmployee(long employeeId, EmployeePayrollDTO employeeDTO) {
        return new EmployeePayrollData(employeeId, employeeDTO.getName(), employeeDTO.getSalary());
    }

    @Override
    public String deleteEmployee(long employeeId) {
        return "Employee with id " + employeeId + " deleted successfully";
    }
}
