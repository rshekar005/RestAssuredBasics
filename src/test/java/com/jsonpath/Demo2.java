/**
 * 
 */
package com.jsonpath;

import io.restassured.path.json.JsonPath;

public class Demo2 {
	public static void main(String[] args) {
		String request="[\r\n"
				+ "  {\r\n"
				+ "  \"firstname\":\"Rajashekar\",\r\n"
				+ "  \"lastname\":\"Pillalamarri\",\r\n"
				+ "  \"age\":27,\r\n"
				+ "  \"address\":[\r\n"
				+ "    {\r\n"
				+ "    \"city\":\"Hyderabad\",\r\n"
				+ "    \"state\":\"Telangana\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "       \"city\":\"Warangal\",\r\n"
				+ "    \"state\":\"Telangana\"\r\n"
				+ "    }\r\n"
				+ "    ]\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "  \"firstname\":\"Narayana\",\r\n"
				+ "  \"lastname\":\"Jonnala\",\r\n"
				+ "  \"age\":27,\r\n"
				+ "  \"address\":[\r\n"
				+ "    {\r\n"
				+ "    \"city\":\"Pulivendula\",\r\n"
				+ "    \"state\":\"AP\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "    \"city\":\"Anantapur\",\r\n"
				+ "    \"state\":\"AP\"\r\n"
				+ "    }\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "]";
		
		JsonPath jsonPath= new JsonPath(request);
		System.out.println(jsonPath.getString("[0].address[0].city"));//Get the city from first array first city
		System.out.println(jsonPath.getString("[1].address[1].city"));//Get the city from second array second city	
		System.out.println(jsonPath.getList("[0].address.city"));//Get the city from first array
		System.out.println(jsonPath.getList("address.city"));//Prints all cities which present in first array and second array
		
	}
}
