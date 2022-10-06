package com.sparta.northwindapi.entity;

import com.sparta.northwindapi.repo.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TerritoryDAO {

    @Autowired
    private TerritoryRepository territoryRepo;

    public  TerritoryDTO update (TerritoryDTO territoryDTO){
        Optional<Territory> optional = territoryRepo.findById(territoryDTO.getId());
        Territory territory=null;
        if (optional.isPresent())
            territory=optional.get();
        else
            return new TerritoryDTO( null,null);
        if (territoryDTO.getTerritoryDescription()!=null)
            territory.setTerritoryDescription(territoryDTO.getTerritoryDescription());
        territoryRepo.save(territory);
        return new TerritoryDTO(territory.getId(),territory.getTerritoryDescription());

    }
}
