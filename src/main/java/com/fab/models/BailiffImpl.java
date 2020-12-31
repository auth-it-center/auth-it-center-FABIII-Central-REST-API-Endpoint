package com.fab.models;

/**
 *
 */
public class BailiffImpl implements Bailiff {


    private Long id;

    private String name;

    private String address;

    private String postalCode;

    private String municipality;

    private String tel;

    private String lang;

    private boolean isSetLang;

    private String country;

    private boolean isSetCountry;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean getIsSetLang() {
        return isSetLang;
    }

    public void setIsSetLang(boolean setLang) {
        isSetLang = setLang;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean getIsSetCountry() {
        return isSetCountry;
    }

    public void setIsSetCountry(boolean setCountry) {
        isSetCountry = setCountry;
    }
}
