package com.bersoft.crudapplication.util;

import com.bersoft.crudapplication.model.domain.Employee;
import com.bersoft.crudapplication.model.request.EmployeeRequest;
import com.bersoft.crudapplication.repository.EmployeeRepository;

import java.util.HashMap;

public class TestUtil {
    public static EmployeeRepository getEmployeeRepositoryWithDatasourcePopulated(){
        return new EmployeeRepository();
    }

    public static EmployeeRepository getEmployeeRepositoryWithDatasourceEmpty(){
        return  new EmployeeRepository(new HashMap<>());
    }

    public static Employee getEmployee(){
        return new Employee(null, "JOHN", "CENA", "USA", 63, 67000D, "77777777");
    }

    public static EmployeeRequest getEmployeeRequest(){
        return new EmployeeRequest("JOHN", "CENA", "USA", 63, 67000D, "77777777");
    }
}
