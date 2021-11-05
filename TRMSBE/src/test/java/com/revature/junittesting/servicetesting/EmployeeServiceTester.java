package com.revature.junittesting.servicetesting;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeRepo;
import com.revature.repositories.EmployeeRepoHBImp;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImp;
import org.junit.jupiter.api.Test;
import sun.nio.cs.ext.MacTurkish;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EmployeeServiceTester {

    EmployeeRepo employeeRepo = new EmployeeRepoHBImp();
    EmployeeService employeeService = new EmployeeServiceImp(employeeRepo);
    Employee twelve = employeeService.getEmployee(12);
    Employee toBeDeleted = employeeService.addEmployee(twelve);

    @Test
    void getEmployee() {

        Employee actual = employeeService.getEmployee(1);
        assertNotEquals(null, actual);
    }

    @Test
    void getAllEmployees() {

        List<Employee> employeeList = employeeService.getAllEmployees();
        assertNotEquals(null, employeeList);

    }

    @Test
    void addEmployee() {

        Employee actual = employeeService.addEmployee(twelve);
        assertNotEquals(null, actual);

    }

    @Test
    void updateEmployee() {

        Employee actual = employeeService.updateEmployee(twelve);
        assertNotEquals(null, actual);

    }

    @Test
    void deleteEmployee() {

        Employee actual = employeeService.deleteEmployee(toBeDeleted);
        assertNotEquals(null, actual);
    }
}
