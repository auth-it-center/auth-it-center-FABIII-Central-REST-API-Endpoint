package com.fab.entities.nl;

import com.fab.entities.pt.BailiffPTMorada;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BailiffNLCompetentBodies {
    @JsonProperty("id")
    private String id;

    @JsonProperty("country")
    private String country;

    @JsonProperty("details")
    private List<BailiffNLDetails> details;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<BailiffNLDetails> getDetails() {
        return  details;
    }

    public void setDetails(List<BailiffNLDetails> details) {
        this.details = (List<BailiffNLDetails>) details;
    }
}
