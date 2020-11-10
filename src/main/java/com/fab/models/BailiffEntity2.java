package com.fab.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name="bailiffs2")
public class BailiffEntity2 {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="country")
    @NotEmpty(message="* Please Enter country")
    private String country;

    @Column(name="lang")
    @NotEmpty(message="* Please Enter lang")
    private String lang;

    @Column(name="name")
    @NotEmpty(message="* Please Enter Full Name")
    private String name;

    @Column(name="address")
    @NotEmpty(message="* Please Enter Address")
    private String address;

    @Column(name="postalcode")
    @NotEmpty(message="* Please Postal Code")
    private String postalCode;

    @Column(name="municipality")
    @NotEmpty(message="* Please Enter Municipality")
    private String municipality;

    @Column(name="tel")
    @NotEmpty(message="* Please Enter Telephone")
    private String tel;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public BailiffEntity2() {
    }

    @Override
    public String toString() {
        return "BailiffEntity2{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", lang='" + lang + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", municipality='" + municipality + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
