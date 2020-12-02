package com.fab.models;

import com.fab.models.Bailiff;
import com.fab.utils.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Embeddable;
import lombok.Data;


@Data
@Embeddable
public class BailiffResponse {

    public BailiffResponse() {
    }

    public BailiffResponse(List<Bailiff> listOfBailiffs, String country, String lang) {
        state = "answered";

        competenceBodies = listOfBailiffs.stream().map(b -> {

           BailiffDetails bd = new BailiffDetails();
           bd.setName(Utilities.transliterate(b.getName(), lang));
           bd.setLang(lang);
           bd.setAddress(Utilities.transliterate(b.getAddress(), lang));
           bd.setPostalCode(b.getPostalCode());
           bd.setMunicipality(Utilities.transliterate(b.getMunicipality(), lang));
           bd.setTel(b.getTel());

           BailiffObject bo = new BailiffObject();

           ArrayList<BailiffDetails> bailiffDetailsList = new ArrayList<>();
           bailiffDetailsList.add(bd);

           bo.setId(b.getId());
           bo.setCountry(country);
           bo.setDetails(bailiffDetailsList);
        
           return bo;
        }).collect(Collectors.toList());
    }

    private String state; 
    private List<BailiffObject> competenceBodies;

    @Data
    @Embeddable
    private class BailiffObject {
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

    @Data
    @Embeddable
    private class BailiffDetails {
        private String name;
        private String lang;
        private String address;
        private String postalCode;
        private String municipality;
        private String tel;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getMunicipality() {
            return municipality;
        }

        public void setMunicipality(String municipality) {
            this.municipality = municipality;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }
}
