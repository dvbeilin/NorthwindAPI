package com.sparta.northwindapi.Controller;

import com.sparta.northwindapi.Entity.Employee;
import com.sparta.northwindapi.Repo.EmployeeRepo;
import com.sparta.northwindapi.Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.time.Instant;
import java.util.List;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepo;
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee result=employeeRepo.findById(id).get();
        return result;
    }
    @GetMapping("/employee/all")
    public List<Employee> getAllActors() {
        List<Employee> list = employeeRepo.findAll();
        return list;
    }

    @DeleteMapping("/employee/{id}")
    public int deleteById(@PathVariable int id){
        Employee employee = employeeRepo.findById(id).get();
        employeeRepo.delete(employee);
        return employee.getId();
    }

    @PutMapping("/employee/{id}/firstName/{newFirstName}")
    public Employee updateFirstName(@PathVariable int id, @PathVariable String newFirstName){
        Employee emp = employeeRepo.findById(id).get();
        emp.setFirstName(newFirstName);
        employeeRepo.save(emp);
        return emp;
    }
   /* @PostMapping("/employee")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void newEmployee(@RequestBody Employee newEmployee){
        EmployeeRepo repo = EmployeeRepo.getInstance();
        repo.add(newEmployee);
    }
    @PostMapping("/employee")
    public Employee newEmployee(int id, String firstName, String lastName, String title, String titleOfCourtesy, Instant birthDate, Instant hireDate,String address, String city, String region,String postalCode,String country, String homePhone,String extension,byte[] photo, String notes, String photoPath, Employee reportsTo,float salary) {
        EmployeeRepo repo = EmployeeRepo.getInstance();

        Employee c = new Employee(id, firstName, lastName, title, titleOfCourtesy,birthDate,hireDate,address,city,region,postalCode,country,homePhone,extension,photo,notes,photoPath,reportsTo,salary);
        repo.add(c);

        return c;
    }*/
}
