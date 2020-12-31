package com.fab.utils;

import com.fab.entities.lv.BailiffLV;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.*;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class HttpsURLConnectionUtilTest extends TestCase {

    private static String LVBailiffsUrl = "https://testbailiff.ta.gov.lv/api/bailiff/getall";

    public void testExecuteGetRequest() {

        String str = HttpsURLConnectionUtil.executeGetRequest(LVBailiffsUrl, new HashMap<String, String>());
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try {
            BailiffLV bailiffLVResponse = mapper.readValue(str, BailiffLV.class);

        assertEquals(bailiffLVResponse.getState(), "ANSWERED");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
