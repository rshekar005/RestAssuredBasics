/**
 * 
 */
package com.handlingresponse;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonArrayResponseToList {
	public static void main(String[] args) {

		// Below Response contains two JsonObjects it means list of 2 objects i,e array
		
		//WithoutTypeRef and CastingjavaObject
		List<Object> all = RestAssured.get("https://run.mocky.io/v3/4bcd4ea0-08cb-4663-9a1f-351ef0f27d0f")
				.as(List.class);
		Map<String, Object> map1 = (Map<String, Object>) all.get(0);
		// Using Typereference and without casting
		List<Map<String, Object>> allEmployee = RestAssured.get("https://run.mocky.io/v3/4bcd4ea0-08cb-4663-9a1f-351ef0f27d0f")
				.as(new TypeRef<List<Map<String, Object>>>(){});
		System.out.println("Number of Json Objects :" + allEmployee.size());

		// Extract 1st JsonObject firstname. Here JsonObject is a map. So converting 1st
		// index JsonObject to Map
		Map<String, Object> map = allEmployee.get(0);
		System.out.println("First Name in 1st JsonObject is :" +map.get("first_name"));
	}

}
