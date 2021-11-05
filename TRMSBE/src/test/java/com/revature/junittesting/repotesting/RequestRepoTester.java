package com.revature.junittesting.repotesting;

import com.revature.models.Request;
import com.revature.repositories.RequestRepo;
import com.revature.repositories.RequestRepoHBImp;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RequestRepoTester {

    RequestRepo requestRepo = new RequestRepoHBImp();
    Request requestOne = requestRepo.getRequest(1);
    Request toBeDeleted = requestRepo.addRequest(requestOne);

    @Test
    void getRequest() {

        Request actual = requestRepo.getRequest(1);
        assertNotEquals(null, actual);
    }

    @Test
    void getAllRequests() {

        List<Request> actual = requestRepo.getAllRequests();
        assertNotEquals(null, actual);

    }

    @Test
    void addRequest() {

        Request actual = requestRepo.addRequest(requestOne);
        assertNotEquals(null, actual);

    }

    @Test
    void updateRequest() {

        Request actual = requestRepo.updateRequest(requestOne);
        assertNotEquals(null, actual);


    }

    @Test
    void deleteRequest() {

        Request actual = requestRepo.deleteRequest(toBeDeleted);
        assertNotEquals(null, actual);
    }
}
