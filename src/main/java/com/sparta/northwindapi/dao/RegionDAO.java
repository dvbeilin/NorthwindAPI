package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.RegionDTO;
import com.sparta.northwindapi.entity.Region;
import com.sparta.northwindapi.repo.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegionDAO {

    @Autowired
    private RegionRepository regionRepo;

    public RegionDAO(RegionRepository regionsRepo) {
        this.regionRepo = regionsRepo;
    }


//    public RegionDTO get(RegionDTO regionDTO) {
//        Optional<Region> optional = regionRepo.find(regionDTO)
//    }


}
