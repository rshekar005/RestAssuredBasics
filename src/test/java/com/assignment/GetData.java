/**
 * 
 */
package com.assignment;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class GetData {
	@Test
	public void getDataPositive() {
		Response response = RestAssured.given().spec(BaseClass.getRequestSpecification()).log().all().pathParam("id", 2)
				.when().get("/{id}").then().assertThat().statusCode(200).log().all()
				.body("data.id", Matchers.equalTo(2))
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("GetSchemaValidation.json")).extract()
				.response();
	}

	@Test
	public void getDataNegative() {
		Response response = RestAssured.given().spec(BaseClass.getRequestSpecification()).log().all().pathParam("id", 0)
				.when().get("/{id}").then().assertThat().statusCode(404).log().all().extract().response();
	}

}
