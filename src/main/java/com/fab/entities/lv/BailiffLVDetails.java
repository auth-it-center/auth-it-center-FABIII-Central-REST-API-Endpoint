package com.fab.entities.lv;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BailiffLVDetails {
    @JsonProperty("lang")
    private String lang;

    @JsonProperty("instrument")
    private String instrument;

    @JsonProperty("competence")
    private String competence;

    @JsonProperty("adress")
    private String adress;

    @JsonProperty("comments")
    private BailiffLVComments comments;

    @JsonProperty("fax")
    private String fax;

    @JsonProperty("email")
    private String email;

    @JsonProperty("gateWay")
    private String gateWay;

    @JsonProperty("municipality")
    private String municipality;

    @JsonProperty("name")
    private String name;

    @JsonProperty("postalCode")
    private String postalCode;

    @JsonProperty("tel")
    private String tel;

    @JsonProperty("videoConference")
    private boolean videoConference;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public BailiffLVComments getComments() {
        return comments;
    }

    public void setComments(BailiffLVComments comments) {
        this.comments = comments;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGateWay() {
        return gateWay;
    }

    public void setGateWay(String gateWay) {
        this.gateWay = gateWay;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isVideoConference() {
        return videoConference;
    }

    public void setVideoConference(boolean videoConference) {
        this.videoConference = videoConference;
    }
}
