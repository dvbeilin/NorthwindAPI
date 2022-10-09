package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {

    List<Region> findByRegionDesc(String regionName);
}