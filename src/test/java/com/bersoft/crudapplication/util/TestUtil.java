package com.bersoft.crudapplication.util;

import com.bersoft.crudapplication.model.domain.Employee;
import com.bersoft.crudapplication.model.request.EmployeeRequest;
import com.bersoft.crudapplication.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestUtil {
    public static EmployeeRepository getEmployeeRepositoryWithDatasourcePopulated(){
        return new EmployeeRepository();
    }

    public static EmployeeRepository getEmployeeRepositoryWithDatasourceEmpty(){
        return  new EmployeeRepository(new HashMap<>());
    }

    public static Employee getEmployeeWithoutId(){
        return new Employee(null, "JOHN", "CENA", "USA", 63, 67000D, "77777777");
    }

    public static Employee getEmployeeWithId(){
        return new Employee(null, "JOHN", "CENA", "USA", 63, 67000D, "77777777");
    }

    public static EmployeeRequest getEmployeeRequest(){
        return new EmployeeRequest("JOHN", "CENA", "USA", 63, 67000D, "77777777");
    }

    public static List<Employee> getEmployeeList (){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add( new Employee(1L, "JOHN", "LENNON", "USA", 19, 3000D, "40212075101"));
        employeeList.add( new Employee(2L, "CARL", "MAX", "Canada", 49, 3600D, "40212075102"));
        employeeList.add( new Employee(3L, "HAROLD", "JAMES", "FRANCE", 29, 3500D, "40212075103"));
        employeeList.add( new Employee(4L, "ANA", "PARKER", "SPAIN", 18, 4000D, "40212075104"));
        employeeList.add( new Employee(5L, "GEORGE", "CURRY", "HAITI", 37, 7000D, "40212075105"));
        return employeeList;
    }
}
