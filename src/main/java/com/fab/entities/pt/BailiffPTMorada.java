package com.fab.entities.pt;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BailiffPTMorada {
    @JsonProperty("moradaasssoc")
    private String address;

    @JsonProperty("localidadeassoc")
    private String municipality;

    @JsonProperty("cp7asso")
    private String postalCode;

    @JsonProperty("WS_Contacto")
    private List<BailiffPTContacts> contacts;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<BailiffPTContacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<BailiffPTContacts> contacts) {
        this.contacts = contacts;
    }
}
