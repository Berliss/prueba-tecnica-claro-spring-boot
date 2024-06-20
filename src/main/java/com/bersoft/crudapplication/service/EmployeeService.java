package com.bersoft.crudapplication.service;

import com.bersoft.crudapplication.mappers.EmployeeMapper;
import com.bersoft.crudapplication.model.domain.Employee;
import com.bersoft.crudapplication.model.exception.MyEmployeeNotFoundException;
import com.bersoft.crudapplication.model.request.EmployeeRequest;
import com.bersoft.crudapplication.model.response.EmployeeResponse;
import com.bersoft.crudapplication.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

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
}
