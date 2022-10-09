package com.sparta.northwindapi.DAO;

import org.springframework.stereotype.Service;


@Service
public class TerritoryDAO {

     /* @Autowired
    private TerritoryRepository territoryRepo;

  public com.sparta.northwindapi.entity.TerritoryDTO update (TerritoryDTO territoryDTO){
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
*/
}