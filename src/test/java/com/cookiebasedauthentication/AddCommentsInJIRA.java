/**
 * 
 */
package com.cookiebasedauthentication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AddCommentsInJIRA {
	
	//This method is used to read data from external file
	public static String getJsonFileAsString(String location) throws IOException{
		return new String(Files.readAllBytes(Paths.get(location)));
	}
	
	@Test
	private void addComments() throws IOException {
		RestAssured.given().cookie("JSESSIONID","F0501678C5E2A5B4CF6E0A5694D803B5")
		.contentType(ContentType.JSON)
		.pathParam("id", "10009")
		.log().all()
			.body(getJsonFileAsString(System.getProperty("user.dir")+"/src/test/java/com/cookiebasedauthentication/comment.json"))
		.post("http://localhost:8080/rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201);
		
		
	}

}
