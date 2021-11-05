package com.revature.services;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeRepo;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService{

    EmployeeRepo employeeRepo;

    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return employeeRepo.getEmployee(employeeId);
    }

//    @Override
//    public Employee getEmployee(String email, String password) {
//
//        Employee employee = employeeRepo.getEmployee(email, password);
//        return employee;
//    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.getAllEmployees();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepo.addEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Employee update) {
        return employeeRepo.updateEmployee(update);
    }

    @Override
    public Employee deleteEmployee(Employee employee) {
        return employeeRepo.deleteEmployee(employee);
    }


}
