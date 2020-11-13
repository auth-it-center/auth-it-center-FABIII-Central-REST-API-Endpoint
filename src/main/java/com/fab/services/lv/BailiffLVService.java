package com.fab.services.lv;

import com.fab.entities.lv.BailiffLVResponse;
import com.fab.models.Bailiff;
import com.fab.models.BailiffImpl;
import com.fab.utils.HttpsURLConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
        String responseJSONString = HttpsURLConnectionUtil.executeGetRequest(LVBailiffsUrl);

        // convert string response to BailiffLVResponse
        ObjectMapper mapper = new ObjectMapper();

        BailiffLVResponse bailiffLVResponse = mapper.readValue(responseJSONString, BailiffLVResponse.class);
        //TODO add Mapper setting

        ArrayList<Bailiff> bailiffEntities = new ArrayList<>();

        bailiffLVResponse.getBailiffLVs().forEach(b -> {

            // convert from BailiffLVs to BailiffGREntity
            Bailiff bailiff = new BailiffImpl();

            // setup id
            String idStr = b.getDistrict();
            long id = Long.parseLong(idStr);
            bailiff.setId(id);

//            //setup country
//            entity.setCountry(BailiffLVService.LVCountry);
//
//            //setup lang
//            entity.setLang(BailiffLVService.LVLang);

            //setup name
            bailiff.setName(b.getFullName());

            // setup address
            bailiff.setAddress(b.getAddress().getFullAddress());

            //setup postal code
            bailiff.setPostalCode(b.getAddress().getPostCode());

            //setup municipality
            bailiff.setMunicipality(b.getAddress().getCity());

            //setup tel
            bailiff.setTel(b.getContacts().getPhone());

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
