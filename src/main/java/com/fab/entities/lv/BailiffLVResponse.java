package com.fab.entities.lv;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BailiffLVResponse {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Actualized")
    private String actualized;

    @JsonProperty("Count")
    private int count;

    @JsonProperty("Data")
    private List<BailiffLV> bailiffLVs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActualized() {
        return actualized;
    }

    public void setActualized(String actualized) {
        this.actualized = actualized;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<BailiffLV> getBailiffLVs() {
        return bailiffLVs;
    }

    public void setBailiffLVs(List<BailiffLV> bailiffLVs) {
        this.bailiffLVs = bailiffLVs;
    }

    @Override
    public String toString() {
        return "BailiffLVResponse{" +
                "id='" + id + '\'' +
                ", actualized='" + actualized + '\'' +
                ", count=" + count +
                ", bailiffLVs=" + bailiffLVs +
                '}';
    }
}
