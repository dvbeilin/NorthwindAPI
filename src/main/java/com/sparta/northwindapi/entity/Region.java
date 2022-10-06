package com.sparta.northwindapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Region")
public class Region {
    @Id
    @Column(name = "RegionID", nullable = false)
    private Integer id;

    @Column(name = "RegionDescription", nullable = false, length = 50)
    private String regionDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }

}