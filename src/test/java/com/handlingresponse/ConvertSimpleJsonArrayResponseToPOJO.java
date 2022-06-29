/**
 * 
 */
package com.handlingresponse;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

/**
 * @author rajasekhar
 *
 */
public class ConvertSimpleJsonArrayResponseToPOJO {

	public static void main(String[] args) {

		// 1st way
		Address[] address = RestAssured.given().when()
				.get("https://run.mocky.io/v3/5ad4cf91-102f-4730-9bcf-09265b2342e6").then().extract().response()
				.as(Address[].class);
		System.out.println("Using Array Concepts");
		System.out.println(address[0].getCity());
		System.out.println(address[1].getCity());

		// 2nd way using typeRef
		List<Address> addressess = RestAssured.given().when()
				.get("https://run.mocky.io/v3/5ad4cf91-102f-4730-9bcf-09265b2342e6").then().extract().response()
				.as(new TypeRef<List<Address>>() {
				});
		System.out.println("Using TypeRef Annonymous class");
		System.out.println(addressess.get(0).getCity());
		System.out.println(addressess.get(1).getCity());
	}

}
