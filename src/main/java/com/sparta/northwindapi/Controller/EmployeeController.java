package com.sparta.northwindapi.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwindapi.DAO.EmployeeDAO;
import com.sparta.northwindapi.DTO.EmployeeDto;
import com.sparta.northwindapi.Entity.Employee;
import com.sparta.northwindapi.Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepo;
    private Employee newEmployee;


    @Autowired
    private EmployeeDAO employeeDAO;
    @GetMapping("/employee/{id}")
    public ResponseEntity<String> getEmployee(@PathVariable int id) {
        ResponseEntity result = null;
       EmployeeDto employeeDto = employeeDAO.get(id);
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        if (employeeDto != null) {
            try {
                result = new ResponseEntity<>(mapper.writeValueAsString(employeeDto), headers, HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            result = new ResponseEntity<>("{\"message\": \"employee not found\" }", headers, HttpStatus.OK);
        }
        return result;
    }

    @GetMapping("/employee/all")
    public List<EmployeeDto> getAllEmployees() {
        return employeeDAO.getAll();
    }

    @PostMapping("/employee/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public int createEmployee(@RequestBody EmployeeDto newEmployee) {
        return employeeDAO.create(newEmployee);
    }
    @PatchMapping("/employee/{id}")
    public ResponseEntity updateOrder(@PathVariable int id, @RequestBody EmployeeDto newEmployee) {
        ResponseEntity result = null;
        EmployeeDto employeeDto = newEmployee;
        employeeDto = employeeDAO.update(employeeDto);
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        HttpHeaders headers = new HttpHeaders();
        if (employeeDto != null) {
            try {
                result = new ResponseEntity<>(mapper.writeValueAsString(employeeDto), headers, HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            result = new ResponseEntity<>("{\"message\": \"employee not found\" }", headers, HttpStatus.OK);
        }
        return result;
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> createOrUpdateOrder(@PathVariable int id, @RequestBody EmployeeDto newEmployee) {
        ResponseEntity result = null;
       EmployeeDto employeeDto = newEmployee;
        employeeDto.setId(id);
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        if (employeeDAO.update(employeeDto) == null) {
            createEmployee(newEmployee);
            try {
                return new ResponseEntity<>(mapper.writeValueAsString(employeeDto), headers, HttpStatus.CREATED);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            updateOrder(id, employeeDto);
            try {
                return new ResponseEntity<>(mapper.writeValueAsString(employeeDto), headers, HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        if (employeeDAO.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("{\"message\": \"employee not found\" }", headers, HttpStatus.NOT_FOUND);
        }
    }

}
