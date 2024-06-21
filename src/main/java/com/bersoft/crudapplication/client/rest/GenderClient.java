package com.bersoft.crudapplication.client.rest;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Service;

@Service
public class GenderClient {

    private final Client restClient;
    private static final String SERVICE_URL = "https://api.genderize.io";
    private static final String PARAM = "name";

    public GenderClient() {
        this.restClient = ClientBuilder.newClient();
    }

    public Response getGender(String name) {
        return restClient.target(SERVICE_URL)
                .queryParam(PARAM, name)
                .request(MediaType.APPLICATION_JSON)
                .get();
    }
}
