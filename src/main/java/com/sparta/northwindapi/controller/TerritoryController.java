package com.sparta.northwindapi.controller;

import com.sparta.northwindapi.entity.Region;
import com.sparta.northwindapi.entity.Territory;
import com.sparta.northwindapi.repo.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class TerritoryController {


    @Autowired
    private TerritoryRepository territoryRepo;

    @GetMapping("/territory/{id}")
    public Territory getTerritoryById(@PathVariable String id){
        Territory result = territoryRepo.findById(id).get();
        return result;
    }





}
