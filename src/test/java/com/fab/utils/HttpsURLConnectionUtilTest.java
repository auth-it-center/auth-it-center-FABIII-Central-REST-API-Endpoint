package com.fab.utils;

import com.fab.entities.lv.BailiffLV;
import com.fab.models.BailiffResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


public class HttpsURLConnectionUtilTest {

//    private static String Fab3URL = "https://fab3.it.auth.gr/fab3/api/v1/bailiffs/lv/getall";
//
//    @Test
//    public void testExecuteGetRequest() throws Exception {
//
//        String str = HttpsURLConnectionUtil.executeGetRequest(Fab3URL, new HashMap<String, String>());
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
//        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
//        try {
//            BailiffResponse bailiffResponse = mapper.readValue(str, BailiffResponse.class);
//
//            Assertions.assertEquals(bailiffResponse.getState(), "answered");
//
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//    }
}
