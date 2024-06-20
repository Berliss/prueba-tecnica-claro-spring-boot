package com.bersoft.crudapplication.service;

import com.bersoft.crudapplication.client.rest.GenderClient;
import com.bersoft.crudapplication.client.soap.NumbersClient;
import com.bersoft.crudapplication.mappers.EmployeeMapper;
import com.bersoft.crudapplication.model.domain.Employee;
import com.bersoft.crudapplication.model.exception.MyEmployeeNotFoundException;
import com.bersoft.crudapplication.model.request.EmployeeRequest;
import com.bersoft.crudapplication.model.response.EmployeeResponse;
import com.bersoft.crudapplication.repository.EmployeeRepository;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final GenderClient genderClient;
    private final NumbersClient numbersClient;

    public List<EmployeeResponse> findAll() {
        return employeeRepository.findAll().stream().map(EmployeeMapper::toEmployeeResponse).toList();
    }

    public EmployeeResponse findById(long id) {
        return employeeRepository.findById(id)
                .map(EmployeeMapper::toEmployeeResponse)
                .orElseThrow(() -> new MyEmployeeNotFoundException(id));
    }

    public EmployeeResponse save(EmployeeRequest employee) {
        return EmployeeMapper.toEmployeeResponse(employeeRepository.save(EmployeeMapper.toEmployee(employee)));
    }

    public EmployeeResponse update(Long id, EmployeeRequest employee) {
        Employee e = EmployeeMapper.toEmployee(employee);
        e.setId(id);
        return EmployeeMapper.toEmployeeResponse(employeeRepository.update(e));
    }

    public boolean delete(Long id) {
        Employee e = employeeRepository.findById(id).orElseThrow(() -> new MyEmployeeNotFoundException(id));
        return employeeRepository.delete(e.getId());
    }

    public Map<String, Object> getGender(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new MyEmployeeNotFoundException(id));
        Response response = genderClient.getGender(employee.getName());
        Map body = response.readEntity(Map.class);
        return Collections.singletonMap("value", body.get("gender"));
    }

    public Map<String,Object> getSalary(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new MyEmployeeNotFoundException(id));
        String value = numbersClient.numberToDollars(employee.getSalary());
        return Collections.singletonMap("value", value);
    }
}
