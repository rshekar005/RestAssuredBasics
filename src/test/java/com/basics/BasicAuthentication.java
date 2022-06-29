/**
 * 
 */
package com.basics;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class BasicAuthentication {
	public static void main(String[] args) {
		String credentials="{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		ValidatableResponse response = RestAssured
				.given().header("Content-Type", "application/json").body(credentials).log().all()
				.when().post("https://restful-booker.herokuapp.com/auth")
				.then().log().all()
					.body("token", Matchers.notNullValue())
					.body("token.length()", Matchers.is(15));
	}

}
