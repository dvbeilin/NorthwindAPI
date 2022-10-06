package com.sparta.northwindapi.Repo;

import com.sparta.northwindapi.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}