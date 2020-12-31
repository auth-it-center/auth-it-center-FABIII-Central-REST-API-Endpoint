package com.fab.services.pt;

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

/**
 *
 */
@Service("bailiffPTService")
public class BailiffPTService {

    private static final String PTBailiffsUrl = "https://qld.osae.eu/IntegrationServices/rest/REST_AE/GetAllAE?Entidade=Agente%20de%20Execu%C3%A7%C3%A3o";
    public static final String PTCountry = "PT";
    private static final String PTLang = "pt";

    private ArrayList<Bailiff> reformatJSON() throws JsonProcessingException {
        // get lv bailiffs
        HashMap<String, String> headers = new HashMap<>();

        headers.put("AppId", "ae");
        headers.put("Key", "123456");

        String responseJSONString = HttpsURLConnectionUtil.executeGetRequest(PTBailiffsUrl, headers);

        // convert string response to BailiffLVResponse
        ObjectMapper mapper = new ObjectMapper();

        List<BailiffPT> bailiffPTResponse = mapper.readValue(responseJSONString, new TypeReference<List<BailiffPT>>(){});
        //BailiffPTResponse bailiffPTResponse = mapper.readValue(responseJSONString, BailiffPTResponse.class);
        //TODO add Mapper setting

        ArrayList<Bailiff> bailiffEntities = new ArrayList<>();

        for (BailiffPT bailiffPT : bailiffPTResponse) {
            Bailiff bailiff = new BailiffImpl();

            String idStr = bailiffPT.getNumcedula();
            long id = Long.parseLong(idStr);
            bailiff.setId(id);

            bailiff.setIsSetLang(false);

            bailiff.setIsSetCountry(false);

            bailiff.setName(bailiffPT.getNome());

            bailiff.setAddress(bailiffPT.getMorada().get(0).getAddress());

            bailiff.setPostalCode(bailiffPT.getMorada().get(0).getPostalCode());

            bailiff.setMunicipality(bailiffPT.getMorada().get(0).getMunicipality());

            bailiff.setTel(bailiffPT.getMorada().get(0).getContacts().get(0).getTel());

            bailiffEntities.add(bailiff);
        }

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
