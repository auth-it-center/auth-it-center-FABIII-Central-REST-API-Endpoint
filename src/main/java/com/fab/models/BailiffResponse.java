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

    private String state;
    private List<BailiffObject> competentBodies;

    public BailiffResponse() {
    }

    public BailiffResponse(List<Bailiff> listOfBailiffs, String country, String lang) {
        state = "answered";

        competentBodies = listOfBailiffs.stream().map(b -> {

           BailiffDetails bd = new BailiffDetails();
           bd.setName(Utilities.transliterate(b.getName(), lang));

           if (b.getIsSetLang()) {
               bd.setLang(b.getLang());
           } else {
               bd.setLang(lang);
           }

           bd.setAddress(Utilities.transliterate(b.getAddress(), lang));
           bd.setPostalCode(b.getPostalCode());
           bd.setMunicipality(Utilities.transliterate(b.getMunicipality(), lang));
           bd.setTel(b.getTel());

           BailiffObject bo = new BailiffObject();

           ArrayList<BailiffDetails> bailiffDetailsList = new ArrayList<>();
           bailiffDetailsList.add(bd);

           bo.setId(b.getId());

           if (b.getIsSetCountry()) {
               bo.setCountry(b.getCountry());
           } else {
               bo.setCountry(country);
           }

           bo.setDetails(bailiffDetailsList);
        
           return bo;
        }).collect(Collectors.toList());
    }
}