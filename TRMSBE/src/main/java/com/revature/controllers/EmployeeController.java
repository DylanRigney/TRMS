package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import io.javalin.http.Handler;

import java.util.List;

public class EmployeeController {

    EmployeeService employeeService;
    Gson gson = new Gson();

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Do I need to make another handler for getEmployeeById or can I combine them both into 1
    // currently just handles getEmployee by email and password for Sign In
//    public Handler getEmployeeEP = (context) -> {
//
//        String email = context.queryParam("email");
//        String password = context.queryParam("password");
//
//        if (email != null && password != null) {
//            Employee employee = employeeService.getEmployee(email, password);
//            context.result(gson.toJson(employee));
//
//        } else  {
//            Employee employee = employeeService.getEmployee()
//        }
//
//    };


    public Handler getEmployeeById = (context) -> {
        String input = context.pathParam("employeeId");
        int employeeId = Integer.parseInt(input);

        Employee employee = employeeService.getEmployee(employeeId);
        context.result(gson.toJson(employee));

    };

    public Handler getAllEmployees = (context) -> {
        List<Employee> employeeList = employeeService.getAllEmployees();

        if (employeeList != null) {
            context.result(gson.toJson(employeeList));
        } else {
            context.result("[]");
        }
    };

    public Handler addEmployee = (context) -> {

    };

    public Handler updateEmployee = (context) -> {

    };

    public Handler deleteEmployee = (context) -> {

    };


}
