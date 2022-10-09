package com.sparta.northwindapi.DTO;

import com.sparta.northwindapi.Entity.Employee;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link Employee} entity
 */
public class EmployeeDto implements Serializable {
    private final Integer id;
    private final String lastName;
    private final String firstName;
    private final String title;
    private final String titleOfCourtesy;
    private final Instant birthDate;
    private final Instant hireDate;
    private final String address;
    private final String city;
    private final String region;
    private final String postalCode;
    private final String country;
    private final String homePhone;
    private final String extension;
    private final String notes;

    private final Float salary;

    public EmployeeDto(Integer id, String lastName, String firstName, String title, String titleOfCourtesy, Instant birthDate, Instant hireDate, String address, String city, String region, String postalCode, String country, String homePhone, String extension, String notes, Float salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        this.titleOfCourtesy = titleOfCourtesy;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.homePhone = homePhone;
        this.extension = extension;
        this.notes = notes;

        this.salary = salary;
    }




    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public Instant getHireDate() {
        return hireDate;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getExtension() {
        return extension;
    }

    public String getNotes() {
        return notes;
    }


    public Float getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto entity = (EmployeeDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.titleOfCourtesy, entity.titleOfCourtesy) &&
                Objects.equals(this.birthDate, entity.birthDate) &&
                Objects.equals(this.hireDate, entity.hireDate) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.region, entity.region) &&
                Objects.equals(this.postalCode, entity.postalCode) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.homePhone, entity.homePhone) &&
                Objects.equals(this.extension, entity.extension) &&
                Objects.equals(this.notes, entity.notes) &&
                Objects.equals(this.salary, entity.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, address, city, region, postalCode, country, homePhone, extension, notes,  salary);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lastName = " + lastName + ", " +
                "firstName = " + firstName + ", " +
                "title = " + title + ", " +
                "titleOfCourtesy = " + titleOfCourtesy + ", " +
                "birthDate = " + birthDate + ", " +
                "hireDate = " + hireDate + ", " +
                "address = " + address + ", " +
                "city = " + city + ", " +
                "region = " + region + ", " +
                "postalCode = " + postalCode + ", " +
                "country = " + country + ", " +
                "homePhone = " + homePhone + ", " +
                "extension = " + extension + ", " +
                "notes = " + notes + ", " +
                "salary = " + salary + ")";
    }
}