package com.sparta.northwindapi.Controller;

import com.sparta.northwindapi.DAO.EmployeeDAO;
import com.sparta.northwindapi.DTO.EmployeeDto;
import com.sparta.northwindapi.Entity.Employee;
import com.sparta.northwindapi.Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

   /* @PatchMapping("/employee/{id}/firstName/{newFirstName}")
    public Employee updateFirstName(@PathVariable int id, @PathVariable String newFirstName) {
        Employee emp = employeeRepo.findById(id).get();
        emp.setFirstName(newFirstName);
        employeeRepo.save(emp);
        return emp;
    }*/
   @PatchMapping("/employee/{id}/firstName/{newFirstName}")
   public EmployeeDto updateFirstName(@PathVariable Integer id, @PathVariable String newFirstName){
       EmployeeDto employeeDTO = new EmployeeDto(id, newFirstName, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
       employeeDTO = employeeDAO.update(employeeDTO);
       return employeeDTO;
   }
   /* @PostMapping("/employee")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void newEmployee(@RequestBody Employee newEmployee){
        EmployeeRepo repo = EmployeeRepo.getInstance();
        repo.add(newEmployee);
    }


    /*@PostMapping("/employee")
    @ResponseStatus(value = HttpStatus.CREATED)
    public int newOrder(@RequestBody Employee newEmployee) {
        employeeRepo.save(newEmployee);
        return newEmployee.getId();
    }*/
   @PostMapping("/employees")
   Employee newEmployee(@RequestBody Employee newEmployee) {
       return employeeRepo.save(newEmployee);
   }

}
