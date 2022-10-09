package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}