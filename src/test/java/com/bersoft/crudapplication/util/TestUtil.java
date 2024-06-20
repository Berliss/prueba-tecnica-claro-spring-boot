package com.bersoft.crudapplication.util;

import com.bersoft.crudapplication.repository.EmployeeRepository;

import java.util.HashMap;

public class TestUtil {
    public static EmployeeRepository getEmployeeRepositoryWithDatasourcePopulated(){
        return new EmployeeRepository();
    }

    public static EmployeeRepository getEmployeeRepositoryWithDatasourceEmpty(){
        return  new EmployeeRepository(new HashMap<>());
    }
}
