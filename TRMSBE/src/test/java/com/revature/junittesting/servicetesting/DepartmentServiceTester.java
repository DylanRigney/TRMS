package com.revature.junittesting.servicetesting;

import com.revature.models.Department;
import com.revature.repositories.DepartmentRepo;
import com.revature.repositories.DepartmentRepoHBImp;
import com.revature.services.DepartmentService;
import com.revature.services.DepartmentServiceImp;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DepartmentServiceTester {


    DepartmentRepo departmentRepo = new DepartmentRepoHBImp();
    DepartmentService departmentService = new DepartmentServiceImp(departmentRepo);

//    @Test
//    void getDepartment() {
//
//    }

    @Test
    void getAllDepartments() {

        List<Department> actual = departmentService.getAllDepartments();


        assertNotEquals(null, actual );

    }

//    @Test
//    void addDepartment() {
//
//
//    }
//
//    @Test
//    void updateDepartment() {
//
//
//    }
//
//    @Test
//    void deleteDepartment() {
//
//
//    }

}
