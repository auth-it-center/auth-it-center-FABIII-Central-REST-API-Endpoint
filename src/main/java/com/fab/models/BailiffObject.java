package com.fab.models;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.List;

@Data
@Embeddable
public class BailiffObject {
    private long id;
    private String country;
    private List<BailiffDetails> details;

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

    public List<BailiffDetails> getDetails() { return details; }

    public void setDetails(List<BailiffDetails> details) {
        this.details = details;
    }
}
