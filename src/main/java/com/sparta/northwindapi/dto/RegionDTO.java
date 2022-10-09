package com.sparta.northwindapi.dto;

import com.sparta.northwindapi.entity.Region;

import java.io.Serializable;
import java.util.Objects;

public class RegionDTO implements Serializable {

    private Integer regionID;

    private String regionDescription;

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }

    public RegionDTO() {

    }

    public RegionDTO(Integer regionID, String regionDescription) {
        this.regionID = regionID;
        this.regionDescription = regionDescription;

    }

    public RegionDTO(Region region){
        this.regionID = region.getId();
        this.regionDescription = region.getRegionDescription();
    }

    @Override
    public String toString() {
        return "RegionDTO{" +
                "regionID=" + regionID +
                ", regionDescription='" + regionDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionDTO regionDTO = (RegionDTO) o;
        return Objects.equals(regionID, regionDTO.regionID) && Objects.equals(regionDescription, regionDTO.regionDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionID, regionDescription);
    }
}
