/**
 * 
 */
package com.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
/**
 * 
 * @author rajasekhar
 **/
public class Oauth2Demo extends BaseClass {

	/**
	 * 
	 * Here authorization is only for chicken feed scope.
	 * But in test 3 we are accessing for egg feed api with valid access token but authorization is only for chicken feed.
	 * So status 401 it means unauthorized.
	 * In test2 scope is correct but passing invalid token.
	 */
	@Test(priority = 1)
	public void validTokenForChickenScope() {
		Response response1 = RestAssured.given().auth().oauth2(BaseClass.performOauth2())
				.post("http://coop.apps.symfonycasts.com/api/1971/chickens-feed");

		String jsonResponseAsString =response1.getBody().asString();
		JsonPath jsonPath= new JsonPath(jsonResponseAsString);
		System.out.println(jsonPath.prettify());
		System.out.println(response1.getStatusCode());
		Assert.assertEquals(200, response1.getStatusCode());
		System.out.println("=============================================");
	}
	
	@Test(priority = 2)
	public void invalidTokenForChickenScope() {
		Response response1 = RestAssured.given().auth().oauth2("sajdhsajdjsahdj")
				.post("http://coop.apps.symfonycasts.com/api/1971/chickens-feed");

		String jsonResponseAsString =response1.getBody().asString();
		JsonPath jsonPath= new JsonPath(jsonResponseAsString);
		System.out.println(jsonPath.prettify());
		System.out.println(response1.getStatusCode());
		Assert.assertEquals(200, response1.getStatusCode());
		System.out.println("=============================================");
	}
	@Test(priority = 3)
	public void invalidEggFeed() {
		Response response1 = RestAssured.given().auth().oauth2(BaseClass.performOauth2())
				.post("http://coop.apps.symfonycasts.com/api/1971/eggs-collect");

		String jsonResponseAsString =response1.getBody().asString();
		JsonPath jsonPath= new JsonPath(jsonResponseAsString);
		System.out.println(jsonPath.prettify());
		System.out.println(response1.getStatusCode());
		Assert.assertEquals(200, response1.getStatusCode());

	}
}
