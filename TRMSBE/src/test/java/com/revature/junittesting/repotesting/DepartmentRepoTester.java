package com.revature.junittesting.repotesting;

import com.revature.models.Department;
import com.revature.repositories.DepartmentRepo;
import com.revature.repositories.DepartmentRepoHBImp;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class DepartmentRepoTester {

    DepartmentRepo departmentRepo = new DepartmentRepoHBImp();


//    @Test
//    void getDepartment() {
//
//    }

    @Test
    void getAllDepartments() {

        List<Department> actual = departmentRepo.getAllDepartments();

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
