package com.fab.fab3.nl;

import com.fab.controllers.lv.BailiffLVController;
import com.fab.entities.nl.BailiffNL;
import com.fab.entities.nl.BailiffNLCompetentBodies;
import com.fab.entities.nl.BailiffNLDetails;
import com.fab.models.Bailiff;
import com.fab.models.BailiffObject;
import com.fab.models.BailiffResponse;
import com.fab.models.BailiffDetails;
import com.fab.services.nl.BailiffNLService;
import com.fab.utils.HttpsURLConnectionUtil;
import com.fab.utils.TestResultLoggerExtension;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.HashMap;

@ExtendWith(TestResultLoggerExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Fab3NetherlandsTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BailiffNLService bailiffNLService;

    // Had to make inner classes in BailiffResponse static
    // If it creates problems these classes can be placed in separate files
    @Test
    public void checkAPIResponseSchema() throws Exception {
        // Make a "REQUEST" to our API
        BailiffResponse response = this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/v1/bailiffs/nl/getall",
                BailiffResponse.class);

        // Check that the state has been set to "answered"
        Assertions.assertEquals("answered", response.getState());

        // Check that the competence bodies are not empty
        Assertions.assertFalse(response.getCompetentBodies().isEmpty());

        // For every item returned in competence bodies
        for (BailiffObject item : response.getCompetentBodies()) {
            // Assert that its class is Bailiff Object
            Assertions.assertEquals(BailiffObject.class, item.getClass());

            // Assert that its field Details in a not empty array
            Assertions.assertFalse(item.getDetails().isEmpty());

            // Assert that the field Details is of class BailiffDetails
            Assertions.assertEquals(BailiffDetails.class, item.getDetails().get(0).getClass());
        }
    }

    @Test
    public void checkNetherlandsAPIResponseSchema() throws Exception {
        // Make a REQUEST to the Netherlands API
        String responseJSONString = HttpsURLConnectionUtil.executeGetRequest(
                "https://webservices.kbvg.nl/services.php",
                new HashMap<String, String>()
        );

        // Convert string response to BailiffNLResponse
        ObjectMapper mapper = new ObjectMapper();
        BailiffNL bailiffNLResponse = mapper.readValue(responseJSONString, BailiffNL.class);

        // Assert that the state is "ANSWERED"
        Assertions.assertEquals("answered", bailiffNLResponse.getState());

        // Assert that the returned competent bodies are not empty
        Assertions.assertFalse(bailiffNLResponse.getCompetentBodies().isEmpty());
    }
}
