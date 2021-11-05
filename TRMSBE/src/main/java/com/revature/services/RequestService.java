package com.revature.services;

import com.revature.models.Employee;
import com.revature.models.Request;


import java.util.List;
import java.util.ListResourceBundle;

public interface RequestService {

    public Request getRequest(int id);

    public List<Request> getAllRequests();

//    public List<Request> getAllRequests(Employee employee);

    public Request addRequest(Request request);

    public  Request updateRequest(Request update);

    public Request deleteRequest(Request request);

    List<Request> requestsForBenco();

    List<Request> requestsForSupervisor(int supervisorId);

    List<Request> requestsForDeptHead(int DeptHeadId);

    List<Request> requestsForEmployee(int employeeId);

    List<Request> resolvedRequests(int employeeId);

    List<Request> getMyRequests(int employeeId);
}
