package com.fab.bailiff.lv;

import com.fab.bailiff.lv.entity.BailiffLVResponse;
import com.fab.models.gr.BailiffEntity;
import com.fab.repositories.gr.BailiffRepository;
import com.fab.utils.HttpsURLConnectionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bailiffLVService")
public class BailiffLVService {

    private static String LVBailiffsUrl = "https://testbailiff.ta.gov.lv/api/bailiff/getall";


    @Autowired
    private BailiffRepository bailiffRepository;

    /**
     *
     */
    public void updateBailiffs() {

        String str = HttpsURLConnectionUtil.executeGetRequest(LVBailiffsUrl);

        ObjectMapper mapper = new ObjectMapper();
        try {
            BailiffLVResponse bailiffLVResponse = mapper.readValue(str, BailiffLVResponse.class);

            bailiffLVResponse.getBailiffLVs().forEach(b -> {

                // convert from BailiffLVs to BailiffEntity
                BailiffEntity e = new BailiffEntity();
                // ....


                // save() method to create or update an existing entry in our database
                bailiffRepository.save(e);
            });

        } catch (JsonProcessingException e) {
            //
            e.printStackTrace();
        }


    }


/**
 *
 *
 * ObjectMapper mapper = new ObjectMapper();
 *             BailiffLVResponse wrap = mapper.readValue(response.toString(), BailiffLVResponse.class);//readTree(response), BailiffLVResponse.class);
 *
 *
 */
}
