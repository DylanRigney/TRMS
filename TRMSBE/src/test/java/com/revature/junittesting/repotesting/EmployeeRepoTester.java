package com.revature.junittesting.repotesting;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeRepo;
import com.revature.repositories.EmployeeRepoHBImp;
import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class EmployeeRepoTester {

    EmployeeRepo employeeRepo = new EmployeeRepoHBImp();
    Employee ceo = employeeRepo.getEmployee(1);
    Employee eleven = employeeRepo.getEmployee(13);
    Employee toBeDeleted = employeeRepo.addEmployee(eleven);


    @Test
    void getEmployee() {

        Employee actual = employeeRepo.getEmployee(1);
        assertNotEquals(null, actual);
    }

    @Test
    void getAllEmployees() {
        List<Employee> actual = employeeRepo.getAllEmployees();
        assertNotEquals(null, actual);

    }

    @Test
    void addEmployee() {

        Employee actual = employeeRepo.addEmployee(ceo);

        assertNotEquals(null, actual);
    }

    @Test
    void  updateEmployee() {
        Employee update = employeeRepo.updateEmployee(ceo);
        assertNotEquals(null, update);

    }

    @Test
    void deleteEmployee() {

        Employee actual = employeeRepo.deleteEmployee(toBeDeleted);
        assertNotEquals(null, actual);

    }
}
