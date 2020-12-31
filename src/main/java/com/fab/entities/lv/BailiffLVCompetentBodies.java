package com.fab.entities.lv;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BailiffLVCompetentBodies {
    @JsonProperty("id")
    private long id;

    @JsonProperty("country")
    private String country;

    @JsonProperty("details")
    private BailiffLVDetails details;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BailiffLVDetails getDetails() {
        return details;
    }

    public void setDetails(BailiffLVDetails details) {
        this.details = details;
    }
}
