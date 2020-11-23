package com.fab.utils;

import com.fab.entities.lv.BailiffLVResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class HttpsURLConnectionUtilTest {

    private static String LVBailiffsUrl = "https://testbailiff.ta.gov.lv/api/bailiff/getall";


    @Test
    public void testExecuteGetRequest() {

        String str = HttpsURLConnectionUtil.executeGetRequest(LVBailiffsUrl, new HashMap<String, String>());
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try {
            BailiffLVResponse bailiffLVResponse = mapper.readValue(str, BailiffLVResponse.class);

            assertThat(bailiffLVResponse.getCount()).isEqualTo(100);

            assertThat(bailiffLVResponse.getBailiffLVs().get(0).getFullName()).isEqualTo("Inese Bože");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

}
