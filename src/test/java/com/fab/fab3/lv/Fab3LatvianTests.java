package com.fab.fab3.lv;

import com.fab.controllers.lv.BailiffLVController;
import com.fab.entities.lv.BailiffLV;
import com.fab.entities.lv.BailiffLVComments;
import com.fab.entities.lv.BailiffLVCompetentBodies;
import com.fab.entities.lv.BailiffLVDetails;
import com.fab.models.Bailiff;
import com.fab.models.BailiffObject;
import com.fab.models.BailiffResponse;
import com.fab.models.BailiffDetails;
import com.fab.services.lv.BailiffLVService;
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
class Fab3LatvianTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private BailiffLVService bailiffLVService;

	// Had to make inner classes in BailiffResponse static
	// If it creates problems these classes can be placed in separate files
	@Test
	public void checkAPIResponseSchema() throws Exception {
		// Make a "REQUEST" to our API
		BailiffResponse response = this.restTemplate.getForObject(
				"http://localhost:" + port + "/api/v1/bailiffs/lv/getall",
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
	public void checkLatvianAPIResponseSchema() throws Exception {
		// Make a REQUEST to the Latvian API
		String responseJSONString = HttpsURLConnectionUtil.executeGetRequest(
				"https://testbailiff.ta.gov.lv/api/bailiff/getall",
				new HashMap<String, String>()
		);

		// Convert string response to BailiffLVResponse
		ObjectMapper mapper = new ObjectMapper();
		BailiffLV bailiffLVResponse = mapper.readValue(responseJSONString, BailiffLV.class);

		// Assert that the state is "ANSWERED"
		Assertions.assertEquals("ANSWERED", bailiffLVResponse.getState());

		// Assert that the returned competent bodies are not empty
		Assertions.assertFalse(bailiffLVResponse.getCompetentBodies().isEmpty());

		// For every competent body
		for (BailiffLVCompetentBodies item : bailiffLVResponse.getCompetentBodies()) {
			// Assert that the field Details is of class BailiffLVDetails
			Assertions.assertEquals(BailiffLVDetails.class, item.getDetails().getClass());

			// Assert that the field Comments is of class BailiffLVComments;
			Assertions.assertEquals(BailiffLVComments.class, item.getDetails().getComments().getClass());
		}
	}
}
