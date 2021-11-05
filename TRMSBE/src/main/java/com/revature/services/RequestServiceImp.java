package com.revature.services;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.repositories.RequestRepo;
import com.revature.repositories.RequestRepoHBImp;

import java.util.ArrayList;
import java.util.List;

public class RequestServiceImp implements RequestService {

    RequestRepo requestRepo;

    public RequestServiceImp(RequestRepo requestRepo) {
        this.requestRepo = requestRepo;
    }

    @Override
    public Request getRequest(int id) {
        return requestRepo.getRequest(id);
    }

    @Override
    public List<Request> getAllRequests() {
        List<Request> requestList;
        List<Request> needDeptApproval = null;

        requestList = requestRepo.getAllRequests();

        if (requestList != null) {
            return requestList;
        } else return null;
    }

    // Test to see if basic functionality works before expanding
//    @Override
//    public List<Request> getAllRequests(Employee employee) {
//        List<Request> requestList = requestRepo.getAllRequests(employee);
//        //System.out.println("A list of requests brought from the database to the service layer " + requestList);
//
//        if (requestList != null) {
//            return requestList;
//        } else {
//            return null;
//        }
//    }

    @Override
    public Request addRequest(Request request) {
        request.setStatusId(1);
        request = requestRepo.addRequest(request);
        if (request != null) {
            return request;
        } else {
            return null;
        }
    }

    @Override
    public Request updateRequest(Request update) {
        return requestRepo.updateRequest(update);
    }

    @Override
    public Request deleteRequest(Request request) {
        return requestRepo.deleteRequest(request);
    }

    @Override
    public List<Request> requestsForBenco() {
        List<Request> requestsForBenco = new ArrayList<>();
        List<Request> requestList = requestRepo.getAllRequests();

        for (Request request: requestList) {

            if(request.getStatusId() == 4 || request.getStatusId() == 7) {

                requestsForBenco.add(request);
            }
        }

        return requestsForBenco;
    }

    @Override
    public List<Request> requestsForSupervisor(int supervisorId) {
        List<Request> requestsForSupervisor = new ArrayList<>();
        List<Request> requestList = requestRepo.getAllRequests();

        for (Request request: requestList) {

            if( (request.getEmpSupervisorId() == supervisorId && request.getStatusId() == 1)
                    || (request.getEmpSupervisorId() == supervisorId && request.getStatusId() == 8) ) {

                requestsForSupervisor.add(request);
            }
        }

        return requestsForSupervisor;
    }

    @Override
    public List<Request> requestsForDeptHead(int DeptHeadId) {
        List<Request> requestsForDeptHead = new ArrayList<>();
        List<Request> requestList = requestRepo.getAllRequests();

        for (Request request: requestList) {

            if( request.getEmpDeptId() == DeptHeadId && request.getStatusId() == 3) {

                requestsForDeptHead.add(request);
            }
        }


        return requestsForDeptHead;
    }

    @Override
    public List<Request> requestsForEmployee(int employeeId) {
        List<Request> requestsForEmployee = new ArrayList<>();
        List<Request> requestList = requestRepo.getAllRequests();

        for(Request request : requestList) {
            if (request.getEmployeeId() == employeeId && request.getStatusId() == 5) {
                requestsForEmployee.add(request);
            }
        }

        return requestsForEmployee;
    }

    @Override
    public List<Request> resolvedRequests(int employeeId) {
        List<Request> resolvedRequests = new ArrayList<>();
        List<Request> requestList = requestRepo.getAllRequests();

        for(Request request : requestList) {
            if ( (request.getEmployeeId() == employeeId && request.getStatusId() == 9) ||
                    (request.getEmployeeId() == employeeId && request.getStatusId() == 10 ) ||
                      (request.getEmployeeId() == employeeId && request.getStatusId() == 11 ) )
            {
                resolvedRequests.add(request);
            }
        }

        return resolvedRequests;
    }

    @Override
    public List<Request> getMyRequests(int employeeId) {
        List<Request> myRequests = new ArrayList<>();
        List<Request> requestList = requestRepo.getAllRequests();

        for(Request request : requestList) {
            if (request.getEmployeeId() == employeeId) {
                myRequests.add(request);
            }
        }

        return myRequests;
    }
}
