/**
 * 
 */
package com.jsonpath;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class FilterDemo1 {
	public static void main(String[] args) {
		File jsonFile = new File(System.getProperty("user.dir") + "/src/test/java/com/jsonpath/People.json");
		JsonPath jsonPath = new JsonPath(jsonFile);

		// To get firstarray firstname object
		System.out.println(jsonPath.getString("[0].firstname"));

		// It will give all firstname
		System.out.println(jsonPath.getList("firstname"));

		// To get the firstname who are having female has gender
		// it -- means particular element. In other words iteration of gender which is
		// having female.
		System.out.println(jsonPath.getList("findAll{it.gender == 'Female'}.firstname"));

		System.out.println(jsonPath.getList("findAll{it.gender == 'Male'}.firstname"));

		// To get the email based on firstname and lastname then need to use find method
		System.out.println(jsonPath.getString("find{it.firstname=='Rahul' & it.lastname=='shetty'}.email"));

		// Get the firstname of all people which is having id greater than or equal to 2
		System.out.println(jsonPath.getList("findAll{it.id>=2}.firstname"));

		// Get the size of JsonObjects in Array
		System.out.println(jsonPath.getInt("size()"));

	}

}
