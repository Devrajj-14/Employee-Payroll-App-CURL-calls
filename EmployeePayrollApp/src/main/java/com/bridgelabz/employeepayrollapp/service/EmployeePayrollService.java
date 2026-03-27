package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * UC5: Service implementation with in-memory List storage.
 * Stores Employee Payroll data in a local ArrayList.
 * Uses AtomicLong for safe auto-increment of employee IDs.
 */
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private final List<EmployeePayrollData> employeeList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return employeeList;
    }

    @Override
    public EmployeePayrollData getEmployeeById(long employeeId) {
        return employeeList.stream()
                .filter(emp -> emp.getEmployeeId() == employeeId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData employee = new EmployeePayrollData(
                idCounter.getAndIncrement(),
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );
        employeeList.add(employee);
        return employee;
    }

    @Override
    public EmployeePayrollData updateEmployee(long employeeId, EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData existingEmployee = getEmployeeById(employeeId);
        if (existingEmployee != null) {
            existingEmployee.setName(employeeDTO.getName());
            existingEmployee.setSalary(employeeDTO.getSalary());
            return existingEmployee;
        }
        return null;
    }

    @Override
    public String deleteEmployee(long employeeId) {
        EmployeePayrollData employee = getEmployeeById(employeeId);
        if (employee != null) {
            employeeList.remove(employee);
            return "Employee with id " + employeeId + " deleted successfully";
        }
        return "Employee with id " + employeeId + " not found";
    }
}
