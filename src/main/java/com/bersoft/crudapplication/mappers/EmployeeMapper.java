package com.bersoft.crudapplication.mappers;

import com.bersoft.crudapplication.model.domain.Employee;
import com.bersoft.crudapplication.model.request.EmployeeRequest;
import com.bersoft.crudapplication.model.response.EmployeeResponse;

public class EmployeeMapper {

    public static EmployeeResponse toEmployeeResponse(Employee e) {
        return new EmployeeResponse(
                e.getId(),
                e.getName(),
                e.getLastname(),
                e.getAddress(),
                e.getAge(),
                e.getSalary(),
                e.getDni()
        );
    }

    public static Employee toEmployee(EmployeeRequest e) {
        return new Employee(
                null,
                e.getName(),
                e.getLastname(),
                e.getAddress(),
                e.getAge(),
                e.getSalary(),
                e.getDni()
        );
    }

}
