package com.fab.utils;

import com.fab.bailiff.lv.entity.BailiffLVResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class HttpsURLConnectionUtilTest {

    private static String LVBailiffsUrl = "https://testbailiff.ta.gov.lv/api/bailiff/getall";


    @Test
    public void testExecuteGetRequest() {

        String str = HttpsURLConnectionUtil.executeGetRequest(LVBailiffsUrl);
        ObjectMapper mapper = new ObjectMapper();
        try {
            BailiffLVResponse bailiffLVResponse = mapper.readValue(str, BailiffLVResponse.class);

            assertThat(bailiffLVResponse.getCount()).isEqualTo(100);

            assertThat(bailiffLVResponse.getBailiffLVs().get(0).getFullName()).isEqualTo("Inese Bože");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

}