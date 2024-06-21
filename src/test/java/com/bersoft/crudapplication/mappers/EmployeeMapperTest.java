package com.bersoft.crudapplication.mappers;

import com.bersoft.crudapplication.model.domain.Employee;
import com.bersoft.crudapplication.model.request.EmployeeRequest;
import com.bersoft.crudapplication.model.response.EmployeeResponse;
import com.bersoft.crudapplication.util.TestUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EmployeeMapperTest {

    @Test
    void toEmployeeResponse(){
        //given
        Employee employee = TestUtil.getEmployeeWithId();
        //when
        EmployeeResponse employeeResponse = EmployeeMapper.toEmployeeResponse(employee);
        //then
        assertEquals(employee.getName(), employeeResponse.name());
        assertEquals(employee.getLastname(), employeeResponse.lastname());
        assertEquals(employee.getAddress(), employeeResponse.address());
        assertEquals(employee.getSalary(), employeeResponse.salary());
        assertEquals(employee.getAge(), employeeResponse.age());
        assertEquals(employee.getDni(), employeeResponse.dni());
    }

    @Test
    void toEmployee(){
        //given
        EmployeeRequest employeeRequest = TestUtil.getEmployeeRequest();
        //when
        Employee employee = EmployeeMapper.toEmployee(employeeRequest);
        //then
        assertEquals(employee.getName(), employeeRequest.getName());
        assertEquals(employee.getLastname(), employeeRequest.getLastname());
        assertEquals(employee.getAddress(), employeeRequest.getAddress());
        assertEquals(employee.getSalary(), employeeRequest.getSalary());
        assertEquals(employee.getAge(), employeeRequest.getAge());
        assertEquals(employee.getDni(), employeeRequest.getDni());
    }
}