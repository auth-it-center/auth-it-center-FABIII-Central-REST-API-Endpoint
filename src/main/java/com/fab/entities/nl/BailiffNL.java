package com.fab.entities.nl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BailiffNL {

    @JsonProperty("state")
    private String state;

    @JsonProperty("competentBodies")
    private List<BailiffNLCompetentBodies> competentBodies;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<BailiffNLCompetentBodies> getCompetentBodies() {
        return competentBodies;
    }

    public void setCompetentBodies(List<BailiffNLCompetentBodies> competentBodies) {
        this.competentBodies = competentBodies;
    }

    @Override
    public String toString() {
        return "BailiffLV{" +
                "state='" + state + '\'' +
                ", competentBodies='" + competentBodies + '\'' +
                '}';
    }
}
