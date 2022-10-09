package com.sparta.northwindapi.entity;

import com.sparta.northwindapi.dto.RegionDTO;

import javax.persistence.*;

@Entity
@Table(name= "Region")
public class Region {

    public Region(RegionDTO regionDTO) {
        this.id = regionDTO.getRegionID();
        this.regionDescription = regionDTO.getRegionDescription();
    }

    public Region() {

    }

    @Id
    @Column(name = "RegionID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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