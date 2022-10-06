package com.sparta.northwindapi.entity.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sparta.northwindapi.entity.Order;
import com.sparta.northwindapi.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

        @Autowired
        private OrderRepository orderRepo;

        @GetMapping("/order/{id}")
        public ResponseEntity getOrder(@PathVariable int id) {
            ResponseEntity result = null;
            Optional<Order> order = orderRepo.findById(id);
            ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-type","application/json");
            if(order.isPresent() ) {
                try {

                    result = new ResponseEntity<>(mapper.writeValueAsString(order.get()),headers, HttpStatus.OK);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            } else {
                result = new ResponseEntity<>("{\"message\": \"Order not found\" }", headers, HttpStatus.OK);
            }
            return result;
        }

        @GetMapping("/order/all")
        public List<Order> getAllOrders() {
            return orderRepo.findAll();
        }

        @PostMapping("/order/")
        @ResponseStatus(value = HttpStatus.CREATED)
        public int newOrder(@RequestBody Order newOrder) {
            orderRepo.save(newOrder);
            return newOrder.getId();
        }

        @PatchMapping("/order/{id}")
        public ResponseEntity updateOrder(@PathVariable int id,@RequestBody Order newOrder) {
            ResponseEntity result = null;
            Optional<Order> orderToUpdate = orderRepo.findById(id);
            ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
            HttpHeaders headers = new HttpHeaders();
            if(orderToUpdate.isPresent()) {
                Order theOrder = orderToUpdate.get();
                theOrder.setOrderDate(newOrder.getOrderDate());
                theOrder.setFreight(newOrder.getFreight());
                theOrder.setRequiredDate(newOrder.getRequiredDate());
                theOrder.setShipAddress(newOrder.getShipAddress());
                theOrder.setShipCity(newOrder.getShipCity());
                theOrder.setShipCountry(newOrder.getShipCountry());
                theOrder.setShipName(newOrder.getShipName());
                theOrder.setShippedDate(newOrder.getShippedDate());
                theOrder.setShipRegion(newOrder.getShipRegion());
                theOrder.setShipPostalCode(newOrder.getShipPostalCode());
                orderRepo.save(theOrder);
                try {
                    result = new ResponseEntity<>(mapper.writeValueAsString(theOrder), headers,HttpStatus.OK);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            } else {
                result = new ResponseEntity<>("{\"message\": \"Order not found\" }", headers, HttpStatus.OK);
            }
            return result;
        }
    }

