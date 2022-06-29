/**
 * 
 */
package com.jsonpath;

import java.util.List;

import io.restassured.path.json.JsonPath;

/**
 * @author rajasekhar
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		String request="[\r\n"
				+ "\"1\",\r\n"
				+ "\"2\",\r\n"
				+ "\"3\",\r\n"
				+ "\"4\"\r\n"
				+ "]";
		JsonPath jsonPath= new JsonPath(request);
		System.out.println("Value present at index 3 is "+jsonPath.getString("[3]")); // Prints the value which present in 3rd index
		
		System.out.println("Size is "+jsonPath.getList("$").size());//Returns the size of Array
		
		String request2="[\r\n"
				+ "  [\r\n"
				+ "\"1\",\r\n"
				+ "\"2\",\r\n"
				+ "\"3\",\r\n"
				+ "\"4\"\r\n"
				+ "],\r\n"
				+ "[\r\n"
				+ "\"5\",\r\n"
				+ "\"6\",\r\n"
				+ "\"7\",\r\n"
				+ "\"8\"\r\n"
				+ "]\r\n"
				+ "]";
		
		JsonPath jsonPath2= new JsonPath(request2);
		System.out.println(jsonPath2.getString("[1][2]")); //Here it will go to second array and print the 2nd index value
		System.out.println(jsonPath2.getList("$").size());//Size of an array
		System.out.println(jsonPath2.getList("$").get(0));// Prints the first array elements
		System.out.println(jsonPath2.getList("$").get(1)); // Prints the second array elements
		List<Object> internalList=(List<Object>) jsonPath2.getList("$").get(0);
		System.out.println("Internal size :" +internalList.size());//Prints the internal list size
		
		
	}
}
