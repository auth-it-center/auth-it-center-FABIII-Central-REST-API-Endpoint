package com.fab.entities.pt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BailiffPTContacts {
    @JsonProperty("contactodesc")
    private String tel;

    @JsonProperty("contactoemailassoc")
    private String email;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
