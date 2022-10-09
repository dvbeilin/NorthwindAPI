package com.sparta.northwindapi.entity.controller;

import com.sparta.northwindapi.entity.Region;
import com.sparta.northwindapi.repo.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RegionController {


    @Autowired
    private RegionRepository regionRepo;

    @GetMapping("/region/{id}")
    public Region getRegionById(@PathVariable int id){
        Region result = regionRepo.findById(id).get();
        return result;
    }

    @GetMapping("/region/all")
    public List<Region> getAllActors(){
        List<Region> list = regionRepo.findAll();
        return list;
    }

    @PostMapping("/region")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void newCustomer(@RequestBody Region newRegion){
//        RegionRepository rep = RegionRepository.getInstance();
//        repo.add(newCustomer);
    }


    @DeleteMapping("/region{id}")
    public int deleteById(@PathVariable int id){
        Region region = regionRepo.findById(id).get();
        regionRepo.delete(region);
        return region.getId();
    }




}
