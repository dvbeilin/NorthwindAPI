package com.sparta.northwindapi.entity.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.northwindapi.entity.Customers;
import com.sparta.northwindapi.entity.Order;
import com.sparta.northwindapi.repo.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CustomersController {
    @Autowired
    private CustomersRepository customersRepo;

    @GetMapping("/customers/{id}")
    public Customers getCustomers(@PathVariable int id){
        Customers result = customersRepo.findById(id).get();
        return result;
    }
    @GetMapping("/customers/all")
    public List<Customers> getAllCustomers(){
        return customersRepo.findAll();
    }

    @PostMapping("/customers/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public int newCustomer(@RequestBody Customers newCustomer) {
        customersRepo.save(newCustomer);
        return newCustomer.getId();
    }

    @PatchMapping("/customers/{id}")
    public ResponseEntity updateCustomers(@PathVariable int id,@RequestBody Customers newCustomers){
        ResponseEntity result = null;
        Optional<Customers> customerToUpdate = customersRepo.findById(id);
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().build();
        HttpHeaders headers = new HttpHeaders();
        if(customerToUpdate.isPresent()){
            Customers theCustomer = customerToUpdate.get();
            theCustomer.setCustomersName(newCustomers.getCustomersName());
            theCustomer.setContactName(newCustomers.getContactName());
            theCustomer.setContactTitle(newCustomers.getContactTitle());
            theCustomer.setAddress(newCustomers.getAddress());
            theCustomer.setCity(newCustomers.getCity());
            theCustomer.setRegion(newCustomers.getRegion());
            theCustomer.setPostalCode(newCustomers.getPostalCode());
            theCustomer.setCountry(newCustomers.getCountry());
            theCustomer.setPhone(newCustomers.getPhone());
            theCustomer.setFax(newCustomers.getFax());
            customersRepo.save(theCustomer);
            try {
                result = new ResponseEntity<>(mapper.writeValueAsString(theCustomer), headers,HttpStatus.OK);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        } else {
            result = new ResponseEntity<>("{\"message\": \"Customer not found\" }", headers, HttpStatus.OK);
        }
        return result;
    }

    @DeleteMapping("/customers/{id}")
    public int deleteById(@PathVariable int id) {
        Customers customers = customersRepo.findById(id).get();
        customersRepo.delete(customers);
        return customers.getId();
    }



}





