package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * UC3: Data Transfer Object for Employee Payroll.
 * Carries data from the client request to the controller/service.
 */
public class EmployeePayrollDTO {

    @NotBlank(message = "Employee name cannot be blank")
    public String name;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 0, message = "Salary must be non-negative")
    public double salary;

    public EmployeePayrollDTO() {
    }

    public EmployeePayrollDTO(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO{name='" + name + "', salary=" + salary + "}";
    }
}
