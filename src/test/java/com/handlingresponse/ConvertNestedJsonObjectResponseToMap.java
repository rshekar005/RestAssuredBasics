/**
 * 
 */
package com.handlingresponse;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class ConvertNestedJsonObjectResponseToMap {
	public static void main(String[] args) {

		/*
		 * { "id":1, 
		 * 	 "first_name":"Rajashekar", 
		 *   "last_name":"Pillalamarri",
		 *   "email":"rshekar005@gmail.com", 
		 *   "gender":"Male", 
		 *   "skills": 
		 *      { "name":"testing", 
		 *        "Proficient": "minimum" 
		 *      } 
		 *  }
		 */
		Map responseBodyAsMap = RestAssured.get("https://run.mocky.io/v3/22528946-bb95-43f6-b571-69ddcedcd74e")
				.as(Map.class);

		// Direct jsonObject
		System.out.println(responseBodyAsMap.get("first_name"));
		// Nested JsonObject Response. Again need to use map because skill set is also a
		// jsonObject
		Map<String, String> map = (Map<String, String>) responseBodyAsMap.get("skills");
		System.out.println(map.get("name"));
		System.out.println(map.get("Proficient"));

		/*
		 * But from above we need to cast respective data type like String or int.
		 * Instead we can use TypeRef abstract class which will internally type cast
		 * 
		 * .as(Typeref<Map<String,Object>>(){}); --> it acts as anonymous inner class
		 * and returns Map<String,Object>
		 */

	}

}
