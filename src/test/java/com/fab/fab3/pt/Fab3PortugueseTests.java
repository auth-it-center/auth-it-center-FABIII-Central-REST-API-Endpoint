package com.fab.fab3.pt;

import com.fab.entities.pt.BailiffPT;
import com.fab.entities.pt.BailiffPTContacts;
import com.fab.entities.pt.BailiffPTMorada;
import com.fab.models.BailiffDetails;
import com.fab.models.BailiffObject;
import com.fab.models.BailiffResponse;
import com.fab.services.pt.BailiffPTService;
import com.fab.utils.HttpsURLConnectionUtil;
import com.fab.utils.TestResultLoggerExtension;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(TestResultLoggerExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Fab3PortugueseTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BailiffPTService bailiffPTService;

    // Had to make inner classes in BailiffResponse static
    // If it creates problems these classes can be placed in separate files
    @Test
    public void checkAPIResponseSchema() throws Exception {
        // Make a "REQUEST" to our API
        BailiffResponse response = this.restTemplate.getForObject(
                "http://localhost:" + port + "/api/v1/bailiffs/pt/getall",
                BailiffResponse.class);

        // Check that the state has been set to "answered"
        Assertions.assertEquals("answered", response.getState());

        // Check that the competence bodies are not empty
        Assertions.assertFalse(response.getCompetenceBodies().isEmpty());

        // For every item returned in competence bodies
        for (BailiffObject item : response.getCompetenceBodies()) {
            // Assert that its class is Bailiff Object
            Assertions.assertEquals(BailiffObject.class, item.getClass());

            // Assert that its field Details in a not empty array
            Assertions.assertFalse(item.getDetails().isEmpty());

            // Assert that the field Details is of class BailiffDetails
            Assertions.assertEquals(BailiffDetails.class, item.getDetails().get(0).getClass());
        }
    }

    @Test
    public void checkPortugueseAPIResponseSchema() throws Exception {
        HashMap<String, String> headers = new HashMap<>();

        headers.put("AppId", "ae");
        headers.put("Key", "123456");

        String responseJSONString = HttpsURLConnectionUtil.executeGetRequest(
                "https://qld.osae.eu/IntegrationServices/rest/REST_AE/GetAllAE?Entidade=Agente%20de%20Execu%C3%A7%C3%A3o",
                headers
        );

        // convert string response to BailiffLVResponse
        ObjectMapper mapper = new ObjectMapper();

        List<BailiffPT> bailiffPTResponse = mapper.readValue(responseJSONString, new TypeReference<List<BailiffPT>>(){});

        Assertions.assertFalse(bailiffPTResponse.isEmpty());



        for (BailiffPT bailiff : bailiffPTResponse) {
            Assertions.assertEquals(BailiffPT.class, bailiff.getClass());

            Assertions.assertFalse(bailiff.getMorada().isEmpty());

            for (BailiffPTMorada morada : bailiff.getMorada()) {
                Assertions.assertEquals(BailiffPTMorada.class, morada.getClass());

                Assertions.assertFalse(morada.getContacts().isEmpty());

                for (BailiffPTContacts contact : morada.getContacts()) {
                    Assertions.assertEquals(BailiffPTContacts.class, contact.getClass());
                }
            }
        }
    }
}
