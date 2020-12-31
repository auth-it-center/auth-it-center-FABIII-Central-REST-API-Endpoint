package com.fab.services.lv;

import com.fab.entities.lv.BailiffLV;
import com.fab.models.Bailiff;
import com.fab.models.BailiffImpl;
import com.fab.utils.HttpsURLConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
@Service("bailiffLVService")
public class BailiffLVService {

    private static final String LVBailiffsUrl = "https://testbailiff.ta.gov.lv/api/bailiff/getall";
    public static final String LVCountry = "LV";
    private static final String LVLang = "lv";

    private ArrayList<Bailiff> reformatJSON() throws JsonProcessingException {
        // get lv bailiffs
        String responseJSONString = HttpsURLConnectionUtil.executeGetRequest(LVBailiffsUrl, new HashMap<String, String>());

        // convert string response to BailiffLVResponse
        ObjectMapper mapper = new ObjectMapper();

        BailiffLV bailiffLVResponse = mapper.readValue(responseJSONString, BailiffLV.class);
        //TODO add Mapper setting

        ArrayList<Bailiff> bailiffEntities = new ArrayList<>();

        bailiffLVResponse.getCompetentBodies().forEach(b -> {

            Bailiff bailiff = new BailiffImpl();

            //setup country
            bailiff.setIsSetCountry(true);
            bailiff.setCountry(b.getCountry());

            // setup lang
            bailiff.setIsSetLang(true);
            bailiff.setLang(b.getDetails().getLang());

            // setup id
            long id = b.getId();
            bailiff.setId(id);

            //setup name
            bailiff.setName(b.getDetails().getName());

            // setup address
            bailiff.setAddress(b.getDetails().getAdress());

            //setup postal code
            bailiff.setPostalCode(b.getDetails().getPostalCode());

            //setup municipality
            bailiff.setMunicipality(b.getDetails().getMunicipality());

            //setup tel
            bailiff.setTel(b.getDetails().getTel());

            // add the entity to an array
            bailiffEntities.add(bailiff);
        });

        return bailiffEntities;
    }

    public ArrayList<Bailiff> getFilteredBailiffs(String postalCode) {

        try {
            ArrayList<Bailiff> bailiffEntities = reformatJSON();

            // TODO use filter stream
            ArrayList<Bailiff> filteredByPostalCodeBailiffEntities = new ArrayList<>();

            for (Bailiff entity : bailiffEntities) {
                if (entity.getPostalCode().equals(postalCode)) {
                    filteredByPostalCodeBailiffEntities.add(entity);
                }
            }

            return filteredByPostalCodeBailiffEntities;

        } catch (JsonProcessingException e) {
            //
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public ArrayList<Bailiff> getAllBailiffs() {
        try {
            return reformatJSON();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

}
