/**
 * 
 */
package com.jsonschema;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

/**
 * @author rajasekhar
 *
 *Link to convert response to Json Schema: https://www.liquid-technologies.com/online-json-to-schema-converter
 *Link to check validation: https://www.jsonschemavalidator.net/
 */
public class Demo1 {
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
					.then().log().all()
						.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingResponseSchema.json"));
	}

}
