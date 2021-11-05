package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "dept_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    @Column(name = "dept_name")
    private String deptName;

    @ManyToOne
    @JoinTable(name="dept_heads",
        joinColumns = @JoinColumn(name = "dept_id"),
        inverseJoinColumns = @JoinColumn(name = "dept_head_id"))
    private Employee departmentHead;



    public Department() {
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return getDeptId() == that.getDeptId() && Objects.equals(getDeptName(), that.getDeptName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeptId(), getDeptName());
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
