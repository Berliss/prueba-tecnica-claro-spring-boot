package com.bersoft.crudapplication.controller;

import com.bersoft.crudapplication.model.request.EmployeeRequest;
import com.bersoft.crudapplication.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@AllArgsConstructor
@Component
public class EmployeeController {

    private EmployeeService service;

    @GET
    public Response findAll() {
        return Response.status(Response.Status.OK).entity(service.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        return Response.status(Response.Status.OK).entity(service.findById(id)).build();
    }

    @POST
    public Response save(@Valid EmployeeRequest employee) {
        return Response.status(Response.Status.CREATED).entity(service.save(employee)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@Valid EmployeeRequest employee, @PathParam("id") long id) {
        return Response.status(Response.Status.OK).entity(service.update(id, employee)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        service.delete(id);
        return Response.noContent().build();
    }

}
