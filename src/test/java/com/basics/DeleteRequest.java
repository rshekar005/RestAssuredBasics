/**
 * 
 */
package com.basics;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteRequest {
	// Delete method is used to delete a resource from the server.
	public static void main(String[] args) {
		String credentials="{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		String token = 
				given().header("Content-Type", "application/json").body(credentials).log().all()
				.when().post("https://restful-booker.herokuapp.com/auth")
				.then().log().all()
					.body("token", Matchers.notNullValue())
					.body("token.length()", Matchers.is(15))
				.extract().response().jsonPath().get("token");
		System.out.println("Token is : "+token);
		
		System.out.println("============================");
		Response response=RestAssured.given().baseUri("https://restful-booker.herokuapp.com/booking/1")
							.cookie("token",token)
							.contentType(ContentType.JSON).log().all()
					.when()
							.delete()
					.then()
							.log().all().extract().response();
		response.then().assertThat().statusCode(201);
	}
}
