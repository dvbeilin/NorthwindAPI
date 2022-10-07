package com.sparta.northwindapi.DAO;

import com.sparta.northwindapi.DTO.EmployeeDto;
import com.sparta.northwindapi.Entity.Employee;
import com.sparta.northwindapi.Repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDAO {
    private EmployeeRepository employeeRepo;

    public EmployeeDAO(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public EmployeeDto update(EmployeeDto employeeDto) {
        Optional<Employee> optional = employeeRepo.findById(employeeDto.getId());
        Employee employee = null;
        if (optional.isPresent())
            employee = optional.get();
        else
            return null;
        //new EmployeeDto(-1, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        if (employeeDto.getFirstName() != null)
            employee.setFirstName(employeeDto.getFirstName());
        if (employeeDto.getLastName() != null)
            employee.setLastName(employeeDto.getLastName());
        if (employeeDto.getTitle() != null)
            employee.setTitle(employeeDto.getTitle());
        if (employeeDto.getTitleOfCourtesy() != null)
            employee.setTitleOfCourtesy(employeeDto.getTitleOfCourtesy());
        if (employeeDto.getBirthDate() != null)
            employee.setBirthDate(employeeDto.getBirthDate());
        if (employeeDto.getHireDate() != null)
            employee.setHireDate(employeeDto.getHireDate());
        if (employeeDto.getAddress() != null)
            employee.setAddress(employeeDto.getAddress());
        if (employeeDto.getCity() != null)
            employee.setCity(employeeDto.getCity());
        if (employeeDto.getRegion() != null)
            employee.setRegion(employeeDto.getRegion());
        if (employeeDto.getCountry() != null)
            employee.setCountry(employeeDto.getCountry());
        if (employeeDto.getPostalCode() != null)
            employee.setPostalCode(employeeDto.getPostalCode());
        if (employeeDto.getHomePhone() != null)
            employee.setHomePhone(employeeDto.getHomePhone());
        if (employeeDto.getExtension() != null)
            employee.setExtension(employeeDto.getExtension());
        if (employeeDto.getNotes() != null)
            employee.setExtension(employeeDto.getExtension());
        if (employeeDto.getSalary() != null)
            employee.setSalary(employeeDto.getSalary());
        employeeRepo.save(employee);
        employee = employeeRepo.findById(employeeDto.getId()).get();
        return new EmployeeDto(employee.getId(),
                employee.getFirstName(), employee.getLastName(), employee.getTitle(), employee.getTitleOfCourtesy(), employee.getBirthDate(), employee.getHireDate(), employee.getAddress(), employee.getCity(), employee.getRegion(), employee.getPostalCode(), employee.getCountry(), employee.getHomePhone(), employee.getExtension(), employee.getNotes(), employee.getSalary(), null);
    }


    public Employee create(Employee employee) {
        return employeeRepo.save(employee);
    }

}