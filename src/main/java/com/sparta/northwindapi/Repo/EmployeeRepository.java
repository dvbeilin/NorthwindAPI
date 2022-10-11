package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}