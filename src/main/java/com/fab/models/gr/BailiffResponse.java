package com.fab.models.gr;

import com.fab.utils.Utilities;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class BailiffResponse {

    public BailiffResponse() {
    }

    public BailiffResponse(List<BailiffEntity> listOfBailiffs, String country, String lang) {
        state = "answered";

        competenceBodies = listOfBailiffs.stream().map(b -> {

           BailiffDetails bd = new BailiffDetails();
           bd.setName(b.getName());
           bd.setLang(lang);
           bd.setAddress(Utilities.transliterate(b.getAddress()));
           bd.setPostalCode(b.getPostalCode());
           bd.setMunicipality(Utilities.transliterate(b.getMunicipality()));
           bd.setTel(b.getTel());

           BailiffObject bo = new BailiffObject();
           bo.setId(b.getId());
           bo.setCountry(country);
           bo.setDetails(bd);
        
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
        private BailiffDetails details;
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
    }
}