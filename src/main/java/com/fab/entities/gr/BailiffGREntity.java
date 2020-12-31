package com.fab.entities.gr;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fab.models.Bailiff;
import lombok.Data;


/**
 * Bailiff object stored at the db
 * and access them via JPA
 */
@Data
@Entity
@Table(name="bailiffs")
public class BailiffGREntity implements Bailiff {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

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

    @Override
    public String getLang() {
        return null;
    }

    @Override
    public void setLang(String lang) {

    }

    @Override
    public boolean getIsSetLang() {
        return false;
    }

    @Override
    public void setIsSetLang(boolean setLang) {

    }

    @Override
    public String getCountry() {
        return null;
    }

    @Override
    public void setCountry(String country) {

    }

    @Override
    public boolean getIsSetCountry() {
        return false;
    }

    @Override
    public void setIsSetCountry(boolean setCountry) {

    }
}