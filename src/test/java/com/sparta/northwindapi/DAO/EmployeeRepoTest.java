package com.sparta.northwindapi.DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwindapi.Entity.Employee;
import com.sparta.northwindapi.Repo.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.net.URL;

class EmployeeRepoTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired

    private Employee newEmployee;
    @Test
    Employee getEmployee() {
        Employee employee = null;
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        try {
            employee = mapper.readValue(new URL("http://localhost:8080/employee/10252"), Employee.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(employee);
        Assertions.assertInstanceOf(Employee.class, employee);
        return employee;
    }


}