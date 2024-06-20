package com.bersoft.crudapplication.configuration;

import com.bersoft.crudapplication.model.exception.MyEmployeeNotFoundException;
import com.bersoft.crudapplication.model.response.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.Collections;


@Provider
public class MyEmployeeNotFoundExceptionMapper implements ExceptionMapper<MyEmployeeNotFoundException> {
    @Override
    public Response toResponse(MyEmployeeNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), Collections.singletonList(e.getMessage()));
        return Response.status(Response.Status.NOT_FOUND).entity(errorResponse).build();
    }
}