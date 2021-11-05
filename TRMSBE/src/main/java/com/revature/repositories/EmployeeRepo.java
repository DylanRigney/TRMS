package com.revature.repositories;

import com.revature.models.Employee;

import java.util.List;

public interface EmployeeRepo {

    public  Employee getEmployee(int id);

    //public Employee getEmployee(String email, String password);

    public List<Employee> getAllEmployees();

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Employee update);

    public Employee deleteEmployee(Employee employee);
}
