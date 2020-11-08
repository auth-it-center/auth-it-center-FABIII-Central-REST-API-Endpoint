package com.fab.bailiff.lv.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BailiffLV {

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("District")
    private String district;

    @JsonProperty("Address")
    private BailiffLVAddress address;

    @JsonProperty("Contacts")
    private BailiffLVContacts contacts;

    @JsonProperty("Account")
    private String account;

    @JsonProperty("WorkingHours")
    private String workingHours;

    @JsonProperty("Substitutes")
    private List<BailiffLVSubstitutes> substitutes;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public BailiffLVAddress getAddress() {
        return address;
    }

    public void setAddress(BailiffLVAddress address) {
        this.address = address;
    }

    public BailiffLVContacts getContacts() {
        return contacts;
    }

    public void setContacts(BailiffLVContacts contacts) {
        this.contacts = contacts;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public List<BailiffLVSubstitutes> getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(List<BailiffLVSubstitutes> substitutes) {
        this.substitutes = substitutes;
    }

    @Override
    public String toString() {
        return "BailiffLV{" +
                "fullName='" + fullName + '\'' +
                ", district='" + district + '\'' +
                ", address=" + address +
                ", contacts=" + contacts +
                ", account='" + account + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ", substitutes=" + substitutes +
                '}';
    }
}
