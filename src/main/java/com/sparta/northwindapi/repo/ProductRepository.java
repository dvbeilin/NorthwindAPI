package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}