package com.bersoft.crudapplication.repository;

import com.bersoft.crudapplication.model.domain.Employee;
import com.bersoft.crudapplication.model.exception.MyEmployeeNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
public class EmployeeRepository {

    private final Map<Long, Employee> employeesDatasource;
    private Long sequence;

    public EmployeeRepository() {
        this.employeesDatasource = new HashMap<>();
        employeesDatasource.put(1L, new Employee(1L, "JOHN", "LENNON", "USA", 19, 3000D, "40212075101"));
        employeesDatasource.put(2L, new Employee(2L, "CARL", "MAX", "Canada", 49, 3600D, "40212075102"));
        employeesDatasource.put(3L, new Employee(3L, "HAROLD", "JAMES", "FRANCE", 29, 3500D, "40212075103"));
        employeesDatasource.put(4L, new Employee(4L, "ANA", "PARKER", "SPAIN", 18, 4000D, "40212075104"));
        employeesDatasource.put(5L, new Employee(5L, "GEORGE", "CURRY", "HAITI", 37, 7000D, "40212075105"));
        sequence = employeesDatasource.keySet().stream().max(Long::compareTo).get();
    }

    public List<Employee> findAll() {
        return employeesDatasource.values().stream().toList();
    }

    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(employeesDatasource.get(id));
    }

    public Employee save(Employee employee) {
        employee.setId(generateId());
        employeesDatasource.put(employee.getId(), employee);
        return employee;
    }

    public Employee update(Employee employee) {
        Employee employeeFound = employeesDatasource.get(employee.getId());
        if (employeeFound == null) {
            throw new MyEmployeeNotFoundException(Objects.requireNonNullElse(employee.getId(), 0L));
        }
        employeesDatasource.put(employee.getId(), employee);
        return employee;
    }

    public boolean delete(Long id) {

        return employeesDatasource.remove(id) != null;
    }

    private Long generateId() {
        return ++sequence;
    }
}
