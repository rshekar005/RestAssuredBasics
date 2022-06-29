/**
 * 
 */
package com.cookiebasedauthentication;

import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteTicketInJIRA{
	
	@Test
	private void deleteTicket(ITestContext context) {
		ISuite suite= context.getSuite();
		Response response =RestAssured.given().cookie("JSESSIONID",suite.getAttribute("sessionID"))
					.pathParam("id", suite.getAttribute("id"))
					.when()
					 .delete("http://localhost:8090/rest/api/2/issue/{id}");
		System.out.println("Response code : "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 204);
					
	}
	
	

}
