package com.bersoft.crudapplication.model.response;

public record EmployeeResponse(Long id,
                               String name,
                               String lastname,
                               String address,
                               Integer age,
                               Double salary,
                               String dni) {
}
