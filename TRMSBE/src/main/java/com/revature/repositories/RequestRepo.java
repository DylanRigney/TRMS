package com.revature.repositories;

import com.revature.models.Employee;
import com.revature.models.Request;

import java.util.List;

public interface RequestRepo {

    Request getRequest(int id);

    List<Request> getAllRequests();

//    List<Request> getAllRequests(Employee employee);

    Request addRequest(Request request);

    Request updateRequest(Request update);

    Request deleteRequest(Request request);
}
