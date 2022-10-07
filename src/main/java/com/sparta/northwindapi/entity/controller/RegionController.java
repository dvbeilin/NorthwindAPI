package com.sparta.northwindapi.entity.controller;

import com.sparta.northwindapi.dao.RegionDAO;
import com.sparta.northwindapi.entity.Region;
import com.sparta.northwindapi.repo.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionRepository regionRepo;

    @Autowired
    private RegionDAO regionDAO;

    @GetMapping("/regions/{id}")
    public Region getRegionById(@PathVariable int id){
        Region result = regionRepo.findById(id).get();
        return result;
    }

    @GetMapping("/region/all")
    public List<Region> getAllActors(){
        List<Region> list = regionRepo.findAll();
        return list;
    }

    @PostMapping("/regions")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void newCustomer(@RequestBody Region newRegion){
//        RegionRepository rep = RegionRepository.getInstance();
//        repo.add(newCustomer);
    }


    @DeleteMapping("/regions/{id}")
    public int deleteById(@PathVariable int id){
        Region region = regionRepo.findById(id).get();
        regionRepo.delete(region);
        return region.getId();
    }




}
