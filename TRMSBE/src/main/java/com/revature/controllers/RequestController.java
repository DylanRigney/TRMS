package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Request;
import com.revature.services.RequestService;
import com.revature.util.TRMSLogger;
import io.javalin.http.Handler;

import java.util.List;


public class RequestController {

    RequestService requestService;
    Gson gson = new Gson();

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    public Handler getRequestById = (context) -> {
        String input = context.pathParam("requestId");
        int requestId;

        try {
            requestId = Integer.parseInt(input);
        } catch (Exception e) {
            requestId = -1;
        }

        Request request = requestService.getRequest(requestId);

        if (request != null) {
            //BankLogger.logger.info("getClientById has succeeded");
            context.result(gson.toJson(request));
        } else {
            context.status(404);
        }
    };

    // Going to have to figure out how to pass an employee from the client(Probably through the body)
    // And then convert that JSON employee back to a java object which is saved here
    // then pass that employee to getAllRequests() to return all requests for an employee
    public Handler getAllRequests = (context) -> {
        List<Request> requestList = requestService.getAllRequests();

        if (requestList != null) {
            context.result(gson.toJson(requestList));
        } else {
            context.result("[]");
        }
//        Employee employee = gson.fromJson(context.body(), Employee.class);
//        List<Request> requestList;
//        System.out.println(employee);
//
//        if (employee != null) {
//            requestList = requestService.getAllRequests(employee);
//        }
//
//        //List<Request> requestList = requestService.getAllRequests();
    };

    public Handler myRequests = (context) -> {
        String id = context.pathParam("employeeId");
        int employeeId = Integer.parseInt(id);

        List<Request> myRequests = requestService.getMyRequests(employeeId);

        context.result(gson.toJson(myRequests));
    };

    public Handler requestsForBenco = (context) -> {
        List<Request> requestsForBenco =  requestService.requestsForBenco();
        TRMSLogger.logger.info("requestsForBenco has been run");


        if(requestsForBenco != null) {
            context.result(gson.toJson(requestsForBenco));

        } else context.status(418);
    };

    public Handler requestsForSupervisor = (context) -> {
        String Id = context.pathParam("supervisorId");
        int supervisorId = Integer.parseInt(Id);

        List<Request> requestsForSupervisor = requestService.requestsForSupervisor(supervisorId);


        context.result(gson.toJson(requestsForSupervisor));


    };

    public Handler requestsForDept = (context) -> {
        String id = context.pathParam("deptHeadId");
        int deptHeadId = Integer.parseInt(id);

        List<Request> requestForDeptHead = requestService.requestsForDeptHead(deptHeadId);


        context.result(gson.toJson(requestForDeptHead));

    };

    public Handler requestsForEmployee = (context) -> {
        String id = context.pathParam("employeeId");
        int employeeId = Integer.parseInt(id);

        List<Request> requestsForEmployee = requestService.requestsForEmployee(employeeId);

        context.result(gson.toJson(requestsForEmployee));

    };

    public Handler resolvedRequests = (context) -> {
        String id = context.pathParam("employeeId");
        int employeeId = Integer.parseInt(id);

        List<Request> resolvedRequests = requestService.resolvedRequests(employeeId);

        context.result(gson.toJson(resolvedRequests));
    };

    public Handler addRequest = (context) -> {

        Request request = gson.fromJson(context.body(), Request.class);

        TRMSLogger.logger.error(request);

        // If the request from the front end is not null
        if(request != null) {
             request = requestService.addRequest(request);
        } else {
            context.status(400);
        }

        // if request from the database is not null
        if (request != null) {
            context.result(gson.toJson(request));
            context.status(201);
        } else context.status(500);
    };

    public Handler updateRequest = (context) -> {
        Request update = gson.fromJson(context.body(), Request.class);

        TRMSLogger.logger.info("So far so good?   " + update);

        if(update != null) {
            update = requestService.updateRequest(update);
        } else {
            context.status(400);
        }

        context.result(gson.toJson(update));
    };




}
