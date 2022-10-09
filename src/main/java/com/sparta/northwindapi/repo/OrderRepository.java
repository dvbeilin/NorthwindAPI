package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByShipName(String shipName);
}