package com.sparta.northwindapi.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="Customers")
public class Customers {
    @Id
    @Column(name ="CustomersID", nullable = false)
    private Integer id;

    @Column(name ="CustomersName", nullable = false, length = 40)
    private String customersName;

    @Column(name ="ContactName", nullable = false, length = 30)
    private String contactName;


    @Column(name ="ContactTitle", nullable = false, length = 30)
    private String contactTitle;

    @Column(name ="Address", nullable = false, length = 60)
    private String address;

    @Column(name ="City", nullable = false, length = 15)
    private String city;

    @Column(name ="Region", nullable = false, length = 15)
    private String region;

    @Column(name ="PostalCode", nullable = false, length = 10)
    private String postalCode;

    @Column(name ="Country", nullable = false, length = 15)
    private String country;

    @Column(name ="Phone", nullable = false, length = 24)
    private Integer phone;

    @Column(name ="Fax", nullable = false, length = 24)
    private String fax;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomersName() {
        return customersName;
    }

    public void setCustomersName(String customersName) {
        this.customersName = customersName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
