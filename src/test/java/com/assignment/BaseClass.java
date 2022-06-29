/**
 * 
 */
package com.assignment;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

  static RequestSpecification requestSpecification;
	@BeforeClass
	public static RequestSpecification getRequestSpecification() {
		if(requestSpecification==null) {
			requestSpecification= RestAssured.given().baseUri("https://reqres.in/").basePath("/api/users");
			return requestSpecification;
		}
		return requestSpecification;
		
	}
}
