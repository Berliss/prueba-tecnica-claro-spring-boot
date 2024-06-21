package com.bersoft.crudapplication.repository;

import com.bersoft.crudapplication.model.domain.Employee;
import com.bersoft.crudapplication.model.exception.MyEmployeeNotFoundException;
import com.bersoft.crudapplication.util.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    @Test
    void findAll_allEmployeeReturned() {
        //given
        EmployeeRepository employeeRepository = TestUtil.getEmployeeRepositoryWithDatasourcePopulated();
        //when
        List<Employee> all = employeeRepository.findAll();
        //then
        assertEquals(all.size(), 5);
    }

    @Test
    void findAll_emptyResult() {
        //given
        EmployeeRepository employeeRepository = TestUtil.getEmployeeRepositoryWithDatasourceEmpty();
        //when
        List<Employee> all = employeeRepository.findAll();
        //then
        assertTrue(all.isEmpty());
    }

    @Test
    void findById_employeeFound() {
        //given
        EmployeeRepository employeeRepository = TestUtil.getEmployeeRepositoryWithDatasourcePopulated();
        //when
        Optional<Employee> employee = employeeRepository.findById(1L);
        //then
        assertTrue(employee.isPresent());
    }

    @Test
    void findById_employeeNotFound() {
        //given
        EmployeeRepository employeeRepository = TestUtil.getEmployeeRepositoryWithDatasourcePopulated();
        //when
        Optional<Employee> employee = employeeRepository.findById(6L);
        //then
        assertTrue(employee.isEmpty());
    }

    @Test
    void save_employeeSaved() {
        //given
        EmployeeRepository employeeRepository = TestUtil.getEmployeeRepositoryWithDatasourcePopulated();
        Employee employee = new Employee(null, "JOHN", "CENA", "USA", 63, 67000D, "77777777");
        //when
        Employee employeeSaved = employeeRepository.save(employee);
        //then
        assertEquals(employeeSaved.getId(), 6);
        assertEquals(employeeRepository.findAll().size(), 6);
    }

    @Test
    void update_employeeUpdated() {
        //given
        EmployeeRepository employeeRepository = TestUtil.getEmployeeRepositoryWithDatasourcePopulated();
        Employee employeeBeforeUpdate = employeeRepository.findById(1L).orElseThrow();
        //when
        Employee employeeUpdated = employeeRepository.update(new Employee(1L, "JOHN-UPDATED", "LENNON-UPDATED", "USA-UPDATED", 20, 4000D, "50212075101"));
        //then
        assertEquals(employeeBeforeUpdate.getId(), employeeUpdated.getId());
        assertNotEquals(employeeBeforeUpdate.getName(), employeeUpdated.getName());
        assertNotEquals(employeeBeforeUpdate.getLastname(), employeeUpdated.getLastname());
        assertNotEquals(employeeBeforeUpdate.getAddress(), employeeUpdated.getAddress());
        assertNotEquals(employeeBeforeUpdate.getSalary(), employeeUpdated.getSalary());
        assertNotEquals(employeeBeforeUpdate.getAge(), employeeUpdated.getAge());
        assertNotEquals(employeeBeforeUpdate.getDni(), employeeUpdated.getDni());
    }

    @Test
    void update_employeeToUpdate_notFound_throwException() {
        //given
        EmployeeRepository employeeRepository = TestUtil.getEmployeeRepositoryWithDatasourcePopulated();
        Employee employee = new Employee(6L, "JOHN-UPDATED", "LENNON-UPDATED", "USA-UPDATED", 20, 4000D, "50212075101");
        //when
        //then
        assertThrows(MyEmployeeNotFoundException.class, () -> employeeRepository.update(employee));
    }

    @Test
    void delete_removeEmployeeFromDataSource() {
        //given
        EmployeeRepository employeeRepository = TestUtil.getEmployeeRepositoryWithDatasourcePopulated();
        //when
        boolean deleted =  employeeRepository.delete(5L);
        //then
        assertEquals(employeeRepository.findAll().size(),4);
        assertTrue(deleted);
    }

    @Test
    void delete_employeeToRemoveNotFound() {
        //given
        EmployeeRepository employeeRepository = TestUtil.getEmployeeRepositoryWithDatasourcePopulated();
        //when
        boolean deleted =  employeeRepository.delete(6L);
        //then
        assertEquals(employeeRepository.findAll().size(),5);
        assertFalse(deleted);
    }
}