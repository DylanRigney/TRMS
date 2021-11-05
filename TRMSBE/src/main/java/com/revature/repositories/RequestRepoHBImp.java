package com.revature.repositories;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RequestRepoHBImp implements RequestRepo{

    @Override
    public Request getRequest(int id) {

        Session session = HibernateUtil.getSession();
        Request request;

        try {
            request = session.get(Request.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return request;
    }

    @Override
    public List<Request> getAllRequests() {
        Session session = HibernateUtil.getSession();
        List<Request> requests;

        try {
            requests = session.createQuery("FROM Request").list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }


        return requests;

    }


    // Looked at the documentation and changed the query.  Needs to be tested
//    @Override
//    public List<Request> getAllRequests(Employee employee) {
//
//        Session session = HibernateUtil.getSession();
//        List<Request> requests;
//
//        // (FROM Request WHERE employee.employeeId)
//        try {
//           requests = session.createQuery("FROM Request as request WHERE request.employeeId = employee.employeeId").list();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            session.close();
//        }
//
//
//        return requests;
//    }


    @Override
    public Request addRequest(Request request) {


        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();


            //request.setRequestId((int)session.save(request));
            session.save(request);


            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            request = null;
        } finally {
             session.close();
        }

        return request;
    }

    @Override
    public Request updateRequest(Request update) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(update);
            transaction.commit();

        } catch (HibernateException e ) {
            e.printStackTrace();
            if(transaction != null)transaction.rollback();
            return null;
        } finally {
            session.close();
        }

        return update;
    }

    // double check once ryan posts code
    @Override
    public Request deleteRequest(Request request) {

        Session session = HibernateUtil.getSession();
        Transaction transaction = null;



        try {
            transaction = session.beginTransaction();

            session.delete(request);

            transaction.commit();
        }catch (HibernateException e) {
            e.printStackTrace();
            if (transaction != null) {
                  transaction.rollback();
            }
            request = null;
        } finally {
            session.close();
        }

        return request;
    }
}
