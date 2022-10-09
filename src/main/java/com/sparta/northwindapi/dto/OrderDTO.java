package com.sparta.northwindapi.dto;

import com.sparta.northwindapi.entity.Order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link Order} entity
 */
public class OrderDTO implements Serializable {
    private Integer id;
    private Instant orderDate;
    private Instant requiredDate;
    private Instant shippedDate;
    private BigDecimal freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, Instant orderDate, Instant requiredDate, Instant shippedDate, BigDecimal freight, String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
        this.id = id;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.orderDate = order.getOrderDate();
        this.requiredDate = order.getRequiredDate();
        this.shippedDate = order.getShippedDate();
        this.freight = order.getFreight();
        this.shipName = order.getShipName();
        this.shipAddress = order.getShipAddress();
        this.shipCity = order.getShipCity();
        this.shipRegion = order.getShipRegion();
        this.shipPostalCode = order.getShipPostalCode();
        this.shipCountry = order.getShipCountry();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
    }

    public Instant getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Instant requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Instant getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Instant shippedDate) {
        this.shippedDate = shippedDate;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO entity = (OrderDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.orderDate, entity.orderDate) &&
                Objects.equals(this.requiredDate, entity.requiredDate) &&
                Objects.equals(this.shippedDate, entity.shippedDate) &&
                Objects.equals(this.freight, entity.freight) &&
                Objects.equals(this.shipName, entity.shipName) &&
                Objects.equals(this.shipAddress, entity.shipAddress) &&
                Objects.equals(this.shipCity, entity.shipCity) &&
                Objects.equals(this.shipRegion, entity.shipRegion) &&
                Objects.equals(this.shipPostalCode, entity.shipPostalCode) &&
                Objects.equals(this.shipCountry, entity.shipCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDate, requiredDate, shippedDate, freight, shipName, shipAddress, shipCity, shipRegion, shipPostalCode, shipCountry);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "orderDate = " + orderDate + ", " +
                "requiredDate = " + requiredDate + ", " +
                "shippedDate = " + shippedDate + ", " +
                "freight = " + freight + ", " +
                "shipName = " + shipName + ", " +
                "shipAddress = " + shipAddress + ", " +
                "shipCity = " + shipCity + ", " +
                "shipRegion = " + shipRegion + ", " +
                "shipPostalCode = " + shipPostalCode + ", " +
                "shipCountry = " + shipCountry + ")";
    }
}