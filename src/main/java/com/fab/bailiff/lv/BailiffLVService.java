package com.fab.bailiff.lv;

import com.fab.bailiff.lv.entity.BailiffLVResponse;
import com.fab.models.BailiffEntity2;
import com.fab.repositories.BailiffRepository2;
import com.fab.utils.HttpsURLConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service("bailiffLVService")
public class BailiffLVService {

    private static String LVBailiffsUrl = "https://testbailiff.ta.gov.lv/api/bailiff/getall";
    private static String LVCountry = "LV";
    private static String LVLang = "LV";

    @Autowired
    private BailiffRepository2 bailiffRepository2;

    /**
     *
     */
    public void updateBailiffs() {

        // get lv bailiffs
        String str = HttpsURLConnectionUtil.executeGetRequest(LVBailiffsUrl);
        // convert string response to BailiffLVResponse
        ObjectMapper mapper = new ObjectMapper();
        try {
            BailiffLVResponse bailiffLVResponse = mapper.readValue(str, BailiffLVResponse.class);

            bailiffLVResponse.getBailiffLVs().forEach(b -> {

                // convert from BailiffLVs to BailiffEntity
                BailiffEntity2 e = new BailiffEntity2();
                // setup id
                String idStr = b.getDistrict();
                long id = Long.parseLong(idStr);
                e.setId(id);

                // setup address
                e.setAddress(b.getAddress().getFullAddress());

                //setup
                e.setCountry(BailiffLVService.LVCountry);

                // save() method to create or update an existing entry in our database
                bailiffRepository2.save(e);
            });

        } catch (JsonProcessingException e) {
            //
            e.printStackTrace();
        }


    }

}
