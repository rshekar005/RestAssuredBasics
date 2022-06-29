/**
 * 
 */
package com.basics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.hamcrest.Matchers;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.response.ValidatableResponse;

public class WriteResponseInTextFile {
	public static void main(String[] args) throws IOException {
		String credentials="{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		Response response = RestAssured
				.given().header("Content-Type", "application/json").body(credentials).log().all()
				.when().post("https://restful-booker.herokuapp.com/auth")
				.then().log().all()
					.body("token", Matchers.notNullValue())
					.body("token.length()", Matchers.is(15))
					.extract().response();
		
	  	//Response as String
	   String responseAsString=	response.asString();
	    // Converting response to byteArray and writting data to file
	   byte[] res=responseAsString.getBytes();
	   File targerFileForString= new File("src/main/resources/targetResponseAsByte.json");
	   Files.write(res, targerFileForString);
	   
	// Getting response as input stream and writing in to a file
			InputStream responseAsInputStream = ((ResponseBodyData) response).asInputStream();
			// Creating a byte array with number of bytes of input stream (available()
			// method)
			byte[] responseAsInputStreamByte = new byte[responseAsInputStream.available()];
			// Reads number of bytes from the input stream and stores them into the byte
			// array responseAsInputStreamByte.
			responseAsInputStream.read(responseAsInputStreamByte);
			// Creating a target file
			File targetFileForInputStream = new File("src/main/resources/targetFileForInputStream.json");
			// Writing into files
			Files.write(responseAsInputStreamByte, targetFileForInputStream);
	 
			// Directly getting a byte array
			byte[] responseAsByteArray = ((ResponseBodyData) response).asByteArray();
			// Creating a target file
			File targetFileForByteArray = new File("src/main/resources/targetFileForByteArray.json");
			// Writing into files
			Files.write(responseAsByteArray, targetFileForByteArray);
	 
	}

}
