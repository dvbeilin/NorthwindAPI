package com.sparta.northwindapi.entity.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwindapi.dao.OrderDAO;
import com.sparta.northwindapi.dto.OrderDTO;
import com.sparta.northwindapi.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping("/order/{id}")
    public ResponseEntity<String> getOrder(@PathVariable int id) {
        ResponseEntity result = null;
        OrderDTO orderDTO = orderDAO.get(id);
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        if (orderDTO != null) {
            try {
                result = new ResponseEntity<>(mapper.writeValueAsString(orderDTO), headers, HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            result = new ResponseEntity<>("{\"message\": \"Order not found\" }", headers, HttpStatus.OK);
        }
        return result;
    }

    @GetMapping("/order/all")
    public List<OrderDTO> getAllOrders() {
        return orderDAO.getAll();
    }

    @PostMapping("/order/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public int createOrder(@RequestBody OrderDTO newOrder) {
        return orderDAO.create(newOrder);
    }

    @PatchMapping("/order/{id}")
    public ResponseEntity updateOrder(@PathVariable int id, @RequestBody OrderDTO newOrder) {
        ResponseEntity result = null;
        OrderDTO orderDTO = newOrder;
        orderDTO = orderDAO.update(orderDTO);
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        HttpHeaders headers = new HttpHeaders();
        if (orderDTO != null) {
            try {
                result = new ResponseEntity<>(mapper.writeValueAsString(orderDTO), headers, HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            result = new ResponseEntity<>("{\"message\": \"Order not found\" }", headers, HttpStatus.OK);
        }
        return result;
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<String> createOrUpdateOrder(@PathVariable int id, @RequestBody OrderDTO newOrder) {
        ResponseEntity result = null;
        OrderDTO orderDTO = newOrder;
        orderDTO.setId(id);
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        if (orderDAO.update(orderDTO) == null) {
            createOrder(newOrder);
            try {
                return new ResponseEntity<>(mapper.writeValueAsString(orderDTO), headers, HttpStatus.CREATED);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            updateOrder(id, orderDTO);
            try {
                return new ResponseEntity<>(mapper.writeValueAsString(orderDTO), headers, HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @DeleteMapping("order/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        if (orderDAO.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("{\"message\": \"Order not found\" }", headers, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("order/")
    public ResponseEntity<String> queryByName(@RequestParam String shipName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json");
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        List<OrderDTO> matchedOrders = orderDAO.findByName(shipName);
        if (matchedOrders.isEmpty()) {
            return new ResponseEntity<>("{\"message\": \"Order not found\" }", headers, HttpStatus.NOT_FOUND);
        } else {
            try {
                return new ResponseEntity<>(mapper.writeValueAsString(matchedOrders), headers, HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

