package com.fab.entities.lv;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BailiffLVContacts {

    @JsonProperty("Phone")
    private String phone;

    @JsonProperty("Fax")
    private String fax;

    @JsonProperty("Email")
    private String Email;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "BailiffLVContacts{" +
                "phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
