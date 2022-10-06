package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
}
