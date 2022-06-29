/**
 * 
 */
package com.assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteResource {

	@Test
	public void deleteResource() {
		RestAssured.given().spec(BaseClass.getRequestSpecification()).pathParam("id", 2).log().all().when()
				.delete("/{id}").then().log().all().assertThat().statusCode(204);
	}
	
	//Here i have passed 0 as id. But API still getting success.
	@Test
	public void negative() {
		RestAssured.given().spec(BaseClass.getRequestSpecification()).pathParam("id", 0).log().all().when()
				.delete("/{id}").then().log().all().assertThat().statusCode(204);
	}

}
