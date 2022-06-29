/**
 * 
 */
package com.handlingresponse;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlingDynamicJsonResponse {
	public static void main(String[] args) {
		
		//Using InstanceOf we can check whether Response is JSONArray(List of Objects) or JSONObject(Map)
		
		Response response=RestAssured.get("https://run.mocky.io/v3/cbf7d31f-e713-431c-a63b-0ee0c4f83569");
		Object responseObject = response.as(Object.class);
		
		if(responseObject instanceof List) {
			List responseAsList = (List) responseObject;
			System.out.println("Number of objects : "+responseAsList.size());
		}else if(responseObject instanceof Map) {
			Map responseAsMap = (Map)responseObject;
			System.out.println(((Map) responseObject).size());
		}
	}

}
