package com.sparta.northwindapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.sparta.northwindapi.Entity.Product} entity
 */
public class ProductDTO implements Serializable {
    private Integer id;
    private String productName;
    private String quantityPerUnit;
    private BigDecimal unitPrice;
    private Integer unitsInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Boolean discontinued = false;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String productName, String quantityPerUnit, BigDecimal unitPrice, Integer unitsInStock, Integer unitsOnOrder, Integer reorderLevel, Boolean discontinued) {
        this.id = id;
        this.productName = productName;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Integer getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Integer unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO entity = (ProductDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.productName, entity.productName) &&
                Objects.equals(this.quantityPerUnit, entity.quantityPerUnit) &&
                Objects.equals(this.unitPrice, entity.unitPrice) &&
                Objects.equals(this.unitsInStock, entity.unitsInStock) &&
                Objects.equals(this.unitsOnOrder, entity.unitsOnOrder) &&
                Objects.equals(this.reorderLevel, entity.reorderLevel) &&
                Objects.equals(this.discontinued, entity.discontinued);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, quantityPerUnit, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "productName = " + productName + ", " +
                "quantityPerUnit = " + quantityPerUnit + ", " +
                "unitPrice = " + unitPrice + ", " +
                "unitsInStock = " + unitsInStock + ", " +
                "unitsOnOrder = " + unitsOnOrder + ", " +
                "reorderLevel = " + reorderLevel + ", " +
                "discontinued = " + discontinued + ")";
    }
}