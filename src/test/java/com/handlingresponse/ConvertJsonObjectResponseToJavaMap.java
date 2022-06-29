/**
 * 
 */
package com.handlingresponse;

import java.util.Map;

import io.restassured.RestAssured;

public class ConvertJsonObjectResponseToJavaMap {
	public static void main(String[] args) {

		// For Serialization or deserialization use jackson databind
		Map responseBodyAsMap = RestAssured.get("https://run.mocky.io/v3/cbf7d31f-e713-431c-a63b-0ee0c4f83569")
				.as(Map.class);

		int id = (Integer) responseBodyAsMap.get("id");
		String firstname = (String) responseBodyAsMap.get("first_name");
		System.out.println(id + "   " +firstname);

	}
}
