/**
 * 
 */
package com.cookiebasedauthentication;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetCookieInJIRA {

	@Test
	private void getCookieID(ITestContext context) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", "rshekar005");
		jsonObject.put("password", "Shekar@1234");

		Response response = RestAssured.given().header("Content-Type", "application/json").body(jsonObject)
				.post("http://localhost:8090/rest/auth/1/session").then().log().all().extract().response();
		System.out.println("Status code :" + response.getStatusCode());
		String sessionId = response.getCookies().get("JSESSIONID");
		ISuite suite = context.getSuite();
		suite.setAttribute("sessionID", sessionId);
		Assert.assertNotNull(sessionId);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
