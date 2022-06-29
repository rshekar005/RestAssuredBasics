/**
 * 
 */
package com.basics;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetRequest {
	public static void main(String[] args) {
		//Get method is used to retrieve the data
	ValidatableResponse valresponse=	RestAssured.given()
						.baseUri("https://restful-booker.herokuapp.com")
					.when()
						.get("/booking")
					.then()
						.assertThat().statusCode(200)
						.body("bookingid.sum()", Matchers.equalTo(55))
						.body("bookingid[3]", Matchers.equalTo(4));
	System.out.println(valresponse.extract().response().jsonPath().prettify());
	}
}
