package com.fab.bailiff.lv.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BailiffLVAddress {

    @JsonProperty("City")
    private String city;

    @JsonProperty("Street")
    private String street;

    @JsonProperty("PostCode")
    private String postCode;

    @JsonProperty("House")
    private String house;

    @JsonProperty("Apartment")
    private String apartment;

    @JsonProperty("FullAddress")
    private String fullAddress;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    @Override
    public String toString() {
        return "BailiffLVAddress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                ", house='" + house + '\'' +
                ", apartment='" + apartment + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }
}
