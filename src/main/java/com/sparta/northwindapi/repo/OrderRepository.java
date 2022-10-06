package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}