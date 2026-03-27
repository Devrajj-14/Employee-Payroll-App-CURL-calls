package com.bridgelabz.employeepayrollapp.model;

/**
 * UC3: Model class representing an Employee Payroll record.
 * Acts as the domain entity used throughout the application layers.
 */
public class EmployeePayrollData {

    private long employeeId;
    private String name;
    private double salary;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(long employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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
        return "EmployeePayrollData{employeeId=" + employeeId
                + ", name='" + name + "'"
                + ", salary=" + salary + "}";
    }
}
