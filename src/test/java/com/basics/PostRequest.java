/**
 * 
 */
package com.basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {

	// Post method is used to insert a new resource in to the server.
	public static void main(String[] args) {
		String requestBody="{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
					  .contentType(ContentType.JSON)
					  .body(requestBody).log().all()
					.when()
						.post("/booking")
					.then().log().all().assertThat().statusCode(200);
	}
}
