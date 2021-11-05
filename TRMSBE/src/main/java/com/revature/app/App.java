package com.revature.app;

import com.revature.controllers.DepartmentController;
import com.revature.controllers.EmployeeController;
import  com.revature.controllers.RequestController;
import com.revature.repositories.*;
import com.revature.services.*;
import com.revature.util.HibernateUtil;
import com.revature.util.TRMSLogger;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        HibernateUtil.getSession();

        establishEmployeeRoutes(app);
        establishRequestRoutes(app);
        establishDepartmentRoutes(app);

        app.start(7000);

        //TRMSLogger.logger.warn("Hibernate and Javalin have successfully started and endoints are being monitored");

    }

    private static void establishDepartmentRoutes(Javalin app) {

        DepartmentRepo departmentRepo = new DepartmentRepoHBImp();
        DepartmentService departmentService = new DepartmentServiceImp(departmentRepo);
        DepartmentController departmentController = new DepartmentController(departmentService);

        app.get("/departments", departmentController.getAllDepartments);
    }

    private static void establishRequestRoutes(Javalin app) {

        //instantiate controllers, services, and repos
        RequestRepo requestRepo = new RequestRepoHBImp();
        RequestService requestService = new RequestServiceImp(requestRepo);
        RequestController requestController = new RequestController(requestService);

        // Get a request by it's ID
        app.get("/requests/:requestId", requestController.getRequestById);

        // Get all needed requests for an employee
        app.get("/requests", requestController.getAllRequests);

        // Get the any requests needed for approvals
        app.get("/requestsForSupervisor/:supervisorId", requestController.requestsForSupervisor);
        app.get("/requestsForDept/:deptHeadId", requestController.requestsForDept);
        app.get("/requestsForBenco", requestController.requestsForBenco);
        app.get("/requestsForEmployee/:employeeId", requestController.requestsForEmployee);
        app.get("/resolvedRequests/:employeeId", requestController.resolvedRequests);
        app.get("/myRequests/:employeeId", requestController.myRequests);


        // POST: Add request  Handle a Request.JSON. use it to populate a Request model and save each Request to the database
        app.post("/requests", requestController.addRequest);

        app.patch("/requests", requestController.updateRequest);



    }


    private static void establishEmployeeRoutes(Javalin app) {

        // Instantiate the controllers, services and repository
        EmployeeRepo employeeRepo = new EmployeeRepoHBImp();
        EmployeeService employeeService = new EmployeeServiceImp(employeeRepo);
        EmployeeController employeeController = new EmployeeController(employeeService);




        // Employee Endpoints
        app.get("/employees/:employeeId", employeeController.getEmployeeById);

        app.get("/employees", employeeController.getAllEmployees);



    }


}
