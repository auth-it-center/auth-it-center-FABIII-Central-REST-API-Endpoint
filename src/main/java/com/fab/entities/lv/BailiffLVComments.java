package com.fab.entities.lv;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BailiffLVComments {
    @JsonProperty("comment")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
