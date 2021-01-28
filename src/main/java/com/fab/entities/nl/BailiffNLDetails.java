package com.fab.entities.nl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BailiffNLDetails {
    @JsonProperty("lang")
    private String lang;

    @JsonProperty("address")
    private String address;

    @JsonProperty("municipality")
    private String municipality;

    @JsonProperty("name")
    private String name;

    @JsonProperty("postalCode")
    private String postalCode;

    @JsonProperty("tel")
    private String tel;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAddress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
