package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.entity.Territory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryRepository extends JpaRepository<Territory, String> {
}