package com.revature.repositories;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class EmployeeRepoHBImp implements EmployeeRepo{


    @Override
    public Employee getEmployee(int id) {
        Session session = HibernateUtil.getSession();
        Employee employee;

        try {
            employee = session.get(Employee.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return employee;
    }

    //  Figure out how to get employee by string and password
//    @Override
//    public Employee getEmployee(String email, String password) {
//
//
//        Session session = HibernateUtil.getSession();
//
//        Employee employee = null;

//        try {
//            Criteria criteria = session.createCriteria(Employee.class);
//            criteria.add(Restrictions.eq(email, password));
//
//            employee = (Employee)  criteria.uniqueResult();

//            List<Employee> employees = criteria.list
//            if (employees.size() > 0) {
//                employee = (Employee) criteria.list().get(0);
//            }

            //CriteriaQuery<Employee> criteria;
            //employee = session.createQuery("FROM Employee WHERE email = email and password = password").unwrap(Employee.class);
            //session.createQuery("FROM Employee WHERE email = email and password = password");


//        } catch (HibernateException e) {
//            e.printStackTrace();
//
//        } finally {
//            session.close();
//        }
//
//        return employee;
//  }

    @Override
    public List<Employee> getAllEmployees() {

        Session session = HibernateUtil.getSession();
        List<Employee> employeeList;

        try {
            employeeList = session.createQuery("FROM Employee").list();

        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return employeeList;
    }

    @Override
    public Employee addEmployee(Employee employee) {

        Session session = HibernateUtil.getSession();


        try {
            session.beginTransaction();

            employee.setEmployeeId((int)session.save(employee));

            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            employee = null;
        } finally {
            session.close();
        }

        return employee;
    }

    @Override
    public Employee updateEmployee(Employee update) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(update);
            transaction.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null)transaction.rollback();
            return null;
        } finally {
            session.close();
        }
        return update;

    }

    // double check once ryan posts code
    @Override
    public Employee deleteEmployee(Employee employee) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;


        try {
          transaction = session.beginTransaction();

          session.delete(employee);

          transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            employee = null;
        } finally {
            session.close();
        }

        return employee;
    }
}
