package com.bersoft.crudapplication.client.rest;

import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenderClientTest {

    @Test
    void getGender_successfulResponse() {
        //given
        GenderClient genderClient = new GenderClient();
        //when
        Response response = genderClient.getGender("berlis");
        //then
        System.out.println(response.readEntity(String.class));
        assertEquals(response.getStatus(),Response.Status.OK.getStatusCode());
    }

    @Test
    void getGender_unSuccessfulResponse() {
        //given
        GenderClient genderClient = new GenderClient();
        //when
        Response response = genderClient.getGender(null);
        //then
        System.out.println(response.readEntity(String.class));
        assertEquals(response.getStatus(),422);
    }


}