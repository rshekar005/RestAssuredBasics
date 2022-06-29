package com.basics;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
public class PutRequest {
	
	//Put method is used to update resources. But in put method we need to pass the entire resource. 
	//If Resource is not available then a new resource will be inserted.
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
		
		String putRequest="{\r\n"
				+ "    \"firstname\" : \"Rajashekar\",\r\n"
				+ "    \"lastname\" : \"Pillalamarri\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		ValidatableResponse response=given().body(putRequest).cookie("token",token).log().all().contentType(ContentType.JSON).
		when().put("https://restful-booker.herokuapp.com/booking/70")
		.then().assertThat().body("firstname",Matchers.equalTo("Rajashekar"))
							.body("lastname", Matchers.equalTo("Pillalamarri")).log().all();
			System.out.println(response.extract().response().jsonPath().prettify());
	}
}
