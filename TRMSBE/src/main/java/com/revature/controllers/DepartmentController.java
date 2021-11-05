package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.services.DepartmentService;
import com.revature.services.EmployeeService;
import com.revature.util.TRMSLogger;
import io.javalin.http.Handler;

import java.util.List;

public class DepartmentController {

    DepartmentService departmentService;
    Gson gson = new Gson();

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

//    public Handler getEmployeeById = (context) -> {
//        String input = context.pathParam("departmentId");
//        int departmentId = Integer.parseInt(input);
//
//        Department department = departmentService.getDepartment(departmentId);
//
//        context.result(gson.toJson(department));
//
//
//    };

    public Handler getAllDepartments = (context) -> {
        List<Department> departmentList = departmentService.getAllDepartments();

        if (departmentList != null) {
            TRMSLogger.logger.info("getAlldepartments has returned a list of departments");
            context.result(gson.toJson(departmentList));
        } else {
            context.result("[]");
        }
    };

//    public Handler addDepartment = (context) -> {
//
//    };
//
//    public Handler updateDepartment = (context) -> {
//
//    };
//
//    public Handler deleteDepartment = (context) -> {
//
//    };
}
