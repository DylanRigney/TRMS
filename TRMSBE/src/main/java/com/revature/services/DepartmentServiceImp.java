package com.revature.services;

import com.revature.models.Department;
import com.revature.repositories.DepartmentRepo;
import com.revature.repositories.EmployeeRepo;

import java.util.List;

public class DepartmentServiceImp implements DepartmentService{

    DepartmentRepo departmentRepo;

    public DepartmentServiceImp(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

//    @Override
//    public Department getDepartment(int id) {
//        return departmentRepo.getDepartment(id);
//    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.getAllDepartments();
    }

//    @Override
//    public Department addDepartment(Department department) {
//        return null;
//    }
//
//    @Override
//    public Department updateDepartment(Department update) {
//        return null;
//    }
//
//    @Override
//    public Department deleteDepartment(Department department) {
//        return null;
//    }
}
