package com.fab.services.nl;

import com.fab.entities.nl.BailiffNL;
import com.fab.entities.pt.BailiffPT;
import com.fab.models.Bailiff;
import com.fab.models.BailiffImpl;
import com.fab.utils.HttpsURLConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("bailiffNLService")
public class BailiffNLService {

/**
 *
 */

    private static final String NLBailiffsUrl = "https://webservices.kbvg.nl/services.php";
    public static final String NLCountry = "NL";
    private static final String NLLang = "nl";

    private ArrayList<Bailiff> reformatJSON() throws JsonProcessingException {
        // get nl bailiffs
        String responseJSONString = HttpsURLConnectionUtil.executeGetRequest(NLBailiffsUrl, new HashMap<String, String>());

        // convert string response to BailiffNLResponse
        ObjectMapper mapper = new ObjectMapper();


        //TODO add Mapper setting

        ArrayList<Bailiff> bailiffEntities = new ArrayList<>();


        BailiffNL bailiffNLResponse = mapper.readValue(responseJSONString, BailiffNL.class);
        //TODO add Mapper setting

        bailiffNLResponse.getCompetentBodies().forEach(b -> {

            Bailiff bailiff = new BailiffImpl();

            //setup country
            bailiff.setIsSetCountry(true);
            bailiff.setCountry(b.getCountry());

            // setup lang
            bailiff.setIsSetLang(true);
            bailiff.setLang(b.getDetails().get(0).getLang());

            // setup id
            long id = Long.parseLong(b.getId().substring(2));
            bailiff.setId(id);

            //setup name
            bailiff.setName(b.getDetails().get(0).getName());

            // setup address
            bailiff.setAddress(b.getDetails().get(0).getAddress());

            //setup postal code
            bailiff.setPostalCode(b.getDetails().get(0).getPostalCode());

            //setup municipality
            bailiff.setMunicipality(b.getDetails().get(0).getMunicipality());

            //setup tel
            bailiff.setTel(b.getDetails().get(0).getTel());

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
