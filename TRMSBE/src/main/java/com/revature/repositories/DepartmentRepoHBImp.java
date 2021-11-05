package com.revature.repositories;

import com.revature.models.Department;
import com.revature.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepartmentRepoHBImp implements DepartmentRepo{

//    @Override
//    public Department getDepartment(int id) {
//        Session session = HibernateUtil.getSession();
//        Department department;
//
//        try {
//            department = session.get(Department.class, id);
//
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            return null;
//
//        } finally {
//             session.close();
//        }
//
//        return department;
//    }

    @Override
    public List<Department> getAllDepartments() {
        Session session = HibernateUtil.getSession();
        List<Department> departmentList;

        try {

            departmentList = session.createQuery("FROM Department").list();

        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return departmentList;
    }

//    @Override
//    public Department addDepartment(Department department) {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = null;
//
//        try {
//            session.beginTransaction();
//            session.save(department);
//
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            if(transaction != null) transaction.rollback();
//            return null;
//        } finally {
//            session.close();
//        }
//
//        return department;
//    }

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
