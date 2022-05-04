package studio.aroundhub.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    private String code;

    private String name;

    private String zipCode;

    private String street;

    private String city;

    private String state;

    public Company(){}

    public Company(String code, String name, String zipCode, String street, String city, String state) {
        this.code = code;
        this.name = name;
        this.zipCode = zipCode;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
