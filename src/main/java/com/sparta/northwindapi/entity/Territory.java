package com.sparta.northwindapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "territories")
public class Territory {
    @Id
    @Column(name = "TerritoryID", nullable = false, length = 20)
    private String id;

    @Column(name = "TerritoryDescription", nullable = false, length = 50)
    private String territoryDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }

}