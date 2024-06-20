package com.bersoft.crudapplication.configuration;

import com.bersoft.crudapplication.model.response.ErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {

        List<String> messages = new ArrayList<>();
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();

        for (ConstraintViolation<?> constraint : constraintViolations) {
            String message = constraint.getMessage();
            String propertyPath = constraint.getPropertyPath().toString().split("\\.")[2];
            messages.add(propertyPath+" "+message);
        }

        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), messages);
        return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();

    }
}