package com.bersoft.crudapplication.configuration;

import com.bersoft.crudapplication.controller.EmployeeController;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api/v1/claro")
public class JerseyConfiguration extends ResourceConfig {
    @PostConstruct
    public void init() {
        register(EmployeeController.class);
        register(ConstraintViolationExceptionMapper.class);
        register(MyEmployeeNotFoundExceptionMapper.class);
    }
}