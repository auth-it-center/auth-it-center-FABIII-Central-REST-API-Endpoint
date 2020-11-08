package com.fab.bailiff.lv.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BailiffLVSubstitutes {

    @JsonProperty("FullName")
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "BailiffLVSubstitutes{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
