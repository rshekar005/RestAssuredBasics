/**
 * 
 */
package com.cookiebasedauthentication;

import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateTicketInJIRA {
	@Test
	private void createIssue(ITestContext context) {
		ISuite suite = context.getSuite();
		Response response = RestAssured.given().contentType(ContentType.JSON).
				cookie("JSESSIONID", suite.getAttribute("sessionID")).body("{\r\n"
				+ "    \"fields\": {\r\n" + "       \"project\":\r\n" + "       {\r\n"
				+ "          \"key\": \"REST\"\r\n" + "       },\r\n"
				+ "       \"summary\": \"First Rest Assured API Ticket\",\r\n"
				+ "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "       \"issuetype\": {\r\n" + "          \"name\": \"Bug\"\r\n" + "       }\r\n" + "   }\r\n" + "}")
				.post("http://localhost:8090/rest/api/2/issue/");

		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().jsonPath().prettify());
		String id = response.getBody().jsonPath().get("id");
		Assert.assertEquals(response.getStatusCode(), 201);
		suite.setAttribute("id", id);

	}

}
