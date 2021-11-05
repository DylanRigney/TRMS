package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity()
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_benco")
    private boolean isBenco;

    @Column(name = "dept_id")
    private int deptId;

//    @ManyToOne
//    @JoinColumn(name = "dept_id")
//    private Department deptId;

    @Column(name = "supervisor_id")
    private int supervisorId;

    public Employee() {
    }

    public Employee(String name, String email, String password, boolean isBenco) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isBenco = isBenco;
    }

    public Employee(String name, String email, String password, boolean isBenco, int deptId, int supervisorId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isBenco = isBenco;
        this.deptId = deptId;
        this.supervisorId = supervisorId;
    }

    public Employee(int employeeId, String name, String email, String password, boolean isBenco, int deptId, int supervisorId) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isBenco = isBenco;
        this.deptId = deptId;
        this.supervisorId = supervisorId;
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getisBenco() {
        return isBenco;
    }

    public void setisBenco(boolean isBenco) {
        this.isBenco = isBenco;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getEmployeeId() == employee.getEmployeeId() && getisBenco() == employee.getisBenco() && getDeptId() == employee.getDeptId() && getSupervisorId() == employee.getSupervisorId() && Objects.equals(getName(), employee.getName()) && Objects.equals(getEmail(), employee.getEmail()) && Objects.equals(getPassword(), employee.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getName(), getEmail(), getPassword(), getisBenco(), getDeptId(), getSupervisorId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isBenco=" + isBenco +
                ", deptId=" + deptId +
                ", supervisorId=" + supervisorId +
                '}';
    }
}
