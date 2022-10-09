package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.OrderDTO;
import com.sparta.northwindapi.dto.RegionDTO;
import com.sparta.northwindapi.entity.Order;
import com.sparta.northwindapi.entity.Region;
import com.sparta.northwindapi.repo.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegionDAO {

    private RegionRepository regionRepo;

    public RegionDAO(RegionRepository regionRepo) {
        this.regionRepo = regionRepo;
    }

    public RegionDTO get(int id) {
        Optional<Region> regOption = regionRepo.findById(id);

        if (regOption.isPresent()) {
            Region reg = regOption.get();
            return new RegionDTO(
                    reg.getId(),
                    reg.getRegionDescription()
            );
        } else return null;
    }

    public List<RegionDTO> getAll() {
        List<Region> regions = regionRepo.findAll();
        if (regions.isEmpty()) {
            return null;
        }
        List<RegionDTO> regionDTO = new ArrayList<>();
        regions.forEach(theRegion -> regionDTO.add(
                new RegionDTO(theRegion.getId(),
                        theRegion.getRegionDescription())));
        return regionDTO;
    }

    public Integer create(RegionDTO regionDTO) {
        Region theRegion = new Region(regionDTO);
        regionRepo.save(theRegion);
        return theRegion.getId();
    }

    public RegionDTO update(RegionDTO regionDTO) {
        Optional<Region> regionOpt = regionRepo.findById(regionDTO.getRegionID());
        Region theRegion = null;
        if (regionOpt.isPresent()) {
            theRegion = regionOpt.get();
        } else {
            return null;
        }
        if (regionDTO.getRegionDescription() != null) theRegion.setRegionDescription(regionDTO.getRegionDescription());
        regionRepo.save(theRegion);
        theRegion = regionRepo.findById(regionDTO.getRegionID()).get();
        return new RegionDTO(
                theRegion.getId(),
                theRegion.getRegionDescription());
    }

    public boolean deleteById(int id) {
        Optional<Region> regionOpt = regionRepo.findById(id);
        if (regionOpt.isPresent()) {
            regionRepo.deleteById(id);
            return true;
        } else return false;
    }

    public List<RegionDTO> findByDescription(String name) {
        List<Region> regions = regionRepo.findByRegionDesc(name);
        List<RegionDTO> regionsDTO = new ArrayList<>();
        regions.forEach(region -> regionsDTO.add(new RegionDTO(region)));
        return regionsDTO;
    }


}
