package com.sparta.northwindapi.entity.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwindapi.entity.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.List;


class OrderControllerTest {

    @Test
    void getOrder() {
        Order order = null;
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        try {
             order = mapper.readValue(new URL("http://localhost:8080/order/10252"), Order.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertNotNull(order);
        Assertions.assertInstanceOf(Order.class,order);
    }

    @Test
    void getAllOrders() {
        List<Order> order = null;
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        try {
            order = mapper.readValue(new URL("http://localhost:8080/order/all"), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        order.forEach(o -> Assertions.assertInstanceOf(Order.class,o));
        System.out.println(order);
    }

    @Test
    void createOrder() {
    }

    @Test
    void updateOrder() {
    }

    @Test
    void createOrUpdateOrder() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void queryByName() {
    }
}