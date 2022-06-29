/**
 * 
 */
package com.parallelExecution;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class TestOne {
	@Test(priority = 1)
	public void createBooking(){
		String requestBody="{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2021-01-01\",\r\n"
				+ "        \"checkout\" : \"2021-12-31\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Lunch\"\r\n"
				+ "}";
	  int bookingid=	RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
					  .contentType(ContentType.JSON)
					  .body(requestBody).log().all()
					.when()
						.post("/booking")
					.then().log().all().assertThat().statusCode(200).extract().response().jsonPath().getInt("bookingid");
	    DataShare.setValue("bookingid", bookingid);
		System.out.println("Thread id is "+Thread.currentThread().getId()+ "  "+ " Created booking id is "+DataShare.getValue("bookingid"));
	}
	
	@Test(priority = 2)
	public void getBookingDetails() throws InterruptedException {
		Thread.sleep(20000);
		System.out.println("Thread id is "+Thread.currentThread().getId()+ "  "+ " retreiving booking id is "+DataShare.getValue("bookingid"));

		int id= (Integer) DataShare.getValue("bookingid");
		RestAssured.given().log().all()
				.baseUri("https://restful-booker.herokuapp.com")
			.when()
				.get("/booking/"+id)
			.then().log().all()
				.assertThat().statusCode(200);
      
		System.out.println("Thread id is "+Thread.currentThread().getId()+ "  "+ " Created booking id is ");
	}
	
	
}
