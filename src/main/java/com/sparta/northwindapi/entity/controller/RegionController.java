package com.sparta.northwindapi.entity.controller;

import com.sparta.northwindapi.entity.Region;
import com.sparta.northwindapi.repo.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class RegionController {


    @Autowired
    private RegionRepository regionRepo;

    @GetMapping("/region/{id}")
    public Region getRegionById(@PathVariable int id){
        Region result = regionRepo.findById(id).get();
        return result;
    }


}
