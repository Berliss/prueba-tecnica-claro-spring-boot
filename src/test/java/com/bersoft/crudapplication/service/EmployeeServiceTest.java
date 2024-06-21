package com.bersoft.crudapplication.service;

import com.bersoft.crudapplication.client.rest.GenderClient;
import com.bersoft.crudapplication.client.soap.NumbersClient;
import com.bersoft.crudapplication.model.domain.Employee;
import com.bersoft.crudapplication.model.exception.MyEmployeeNotFoundException;
import com.bersoft.crudapplication.model.response.EmployeeResponse;
import com.bersoft.crudapplication.repository.EmployeeRepository;
import com.bersoft.crudapplication.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private NumbersClient numbersClient;

    @Mock
    private GenderClient genderClient;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void findAll_allEmployeeResponseReturned() {
        //given
        when(employeeRepository.findAll()).thenReturn(TestUtil.getEmployeeList());
        //when
        List<EmployeeResponse> employeeList = employeeService.findAll();
        //then
        assertFalse(employeeList.isEmpty());
        assertEquals(employeeList.size(), 5);
    }

    @Test
    void findAll_emptyResult() {
        //given
        when(employeeRepository.findAll()).thenReturn(new ArrayList<>());
        //when
        List<EmployeeResponse> employeeList = employeeService.findAll();
        //then
        assertTrue(employeeList.isEmpty());
    }

    @Test
    void findById_employeeResponseFound() {
        //given
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(TestUtil.getEmployeeWithId()));
        //when
        EmployeeResponse employeeResponse = employeeService.findById(1);
        //then
        assertNotNull(employeeResponse);
    }

    @Test
    void findById_employeeResponseNotFound_throwsMyEmployeeNotFoundException() {
        //given
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.empty());
        //when
        //then
        assertThrows(MyEmployeeNotFoundException.class, () -> employeeService.findById(1));
    }

    @Test
    void save_employeeSaved() {
        //given
        Employee employee = TestUtil.getEmployeeWithoutId();
        when(employeeRepository.save(employee)).thenAnswer(invocation -> {
            employee.setId(6L);
            return employee;
        });
        //when
        EmployeeResponse employeeResponse = employeeService.save(TestUtil.getEmployeeRequest());
        //then
        assertNotNull(employeeResponse);
        assertEquals(employee.getId(), 6);
        assertEquals(employee.getName(), employeeResponse.name());
        assertEquals(employee.getLastname(), employeeResponse.lastname());
        assertEquals(employee.getAddress(), employeeResponse.address());
        assertEquals(employee.getSalary(), employeeResponse.salary());
        assertEquals(employee.getAge(), employeeResponse.age());
        assertEquals(employee.getDni(), employeeResponse.dni());
    }

    @Test
    void update_employeeUpdated() {
        //given

        when(employeeRepository.update(any())).thenReturn(
                new Employee(1L,
                        "JOHN-UPDATED",
                        "LENNON-UPDATED",
                        "USA-UPDATED",
                        20,
                        4000D,
                        "50212075101")
        );
        //when
        EmployeeResponse employeeResponse = employeeService.update(1L, TestUtil.getEmployeeRequest());

        assertNotNull(employeeResponse);
        verify(employeeRepository, times(1)).update(any());
    }

    @Test
    void delete_whenEmployeeNotExist_throwsException() {
        //given
        Long id = 1L;
        when(employeeRepository.findById(id)).thenThrow(new MyEmployeeNotFoundException(id));
        //when
        //then
        assertThrows(MyEmployeeNotFoundException.class, () -> employeeService.delete(id));
        verify(employeeRepository,times(1)).findById(id);
        verify(employeeRepository,never()).delete(id);
    }

    @Test
    void delete_whenEmployeeExist_returnTrue() {
        //given
        when(employeeRepository.findById(any())).thenReturn(Optional.of(TestUtil.getEmployeeWithId()));
        when(employeeRepository.delete(any())).thenReturn(true);
        //when
        boolean value = employeeService.delete(1L);
        //then
        assertTrue(value);
    }

}