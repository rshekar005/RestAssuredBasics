package com.handlingresponse;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * 
 */

/**
 * @author rajasekhar
 *
 */
public class GetRequest {
	
	public static void main(String[] args) {
		Response response=RestAssured.given()
					.log()
					.all()
					.get("https://run.mocky.io/v3/cbf7d31f-e713-431c-a63b-0ee0c4f83569")
					.then()
					.log()
					.all()
					.extract().response();
		Assert.assertEquals(response.statusCode(), 200);
	}

}
