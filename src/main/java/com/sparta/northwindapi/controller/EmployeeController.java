package com.sparta.northwindapi.controller;

import com.sparta.northwindapi.Entity.Employee;
import com.sparta.northwindapi.Repo.EmployeeRepo;

import com.sparta.northwindapi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.time.Instant;
import java.util.List;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepo;
    private Employee newEmployee;

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee result = employeeRepo.findById(id).get();
        return result;
    }

    @GetMapping("/employee/all")
    public List<Employee> getAllActors() {
        List<Employee> list = employeeRepo.findAll();
        return list;
    }

    @DeleteMapping("/employee/{id}")
    public int deleteById(@PathVariable int id) {
        Employee employee = employeeRepo.findById(id).get();
        employeeRepo.delete(employee);
        return employee.getId();
    }

    @PatchMapping("/employee/{id}/firstName/{newFirstName}")
    public Employee updateFirstName(@PathVariable int id, @PathVariable String newFirstName) {
        Employee emp = employeeRepo.findById(id).get();
        emp.setFirstName(newFirstName);
        employeeRepo.save(emp);
        return emp;
    }
    @PostMapping("/employee")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void newEmployee(@RequestBody Employee newEmployee){
        EmployeeRepo repo = EmployeeRepo.getInstance();
        repo.add(newEmployee);
    }


    /*@PostMapping("/employee")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        employeeRepo.save(newEmployee);
        return newEmployee;
    }*/

}
