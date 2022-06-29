/**
 * 
 */
package com.assignment;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateResource {
	
	@Test
	public void createResource() {
		Map<String, String> map= new HashMap<String, String>();
		map.put("name", "raja");
		map.put("job", "SE");
		
		RestAssured.given().spec(BaseClass.getRequestSpecification()).log().all()
						.body(map)
					.when()
						.post()
					.then()
						.log().all()
					    .assertThat().statusCode(201)
					    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("PostSchemaValidation.json"))
					    .body("id", Matchers.notNullValue());
	}
	
	//For this API passed invalid payload but it is getting success. API end should return 400 Bad request.
	@Test
	public void createResourceWithOutData() {
		Map<Object, Object> map= new HashMap<Object, Object>();
		map.put("name", 123);
		map.put("job", 123);
		map.put("wrongparam", null);
		RestAssured.given().spec(BaseClass.getRequestSpecification()).log().all()
						.body(map)
					.when()
						.post()
					.then()
						.log().all()
					    .assertThat().statusCode(400)
					   ;
	}

}
