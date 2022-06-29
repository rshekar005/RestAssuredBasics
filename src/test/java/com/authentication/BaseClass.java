/**
 * 
 */
package com.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseClass {

	protected static String performOauth2() {
		Response response = RestAssured.given().formParam("client_id", "Learn Automation")
				.formParam("client_secret", "e69b8eb61b789af05d7feb6151628b5c")
				.formParam("grant_type", "client_credentials")
				.post("http://coop.apps.symfonycasts.com/token");

		String access_token = response.jsonPath().getString("access_token");
		System.out.println(access_token);
		return access_token;

	}

}
