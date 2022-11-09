package org.rest.assured.project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestassuredStudentdetails_TC002 {

	
	String studentEndpoint = "https://thetestingworldapi.com/api/studentsDetails/3845758";
	
	@Test
	public void getStudentDetails() {
	
		Response response = RestAssured.get(studentEndpoint);
		System.out.println("Status code "+response.getStatusCode());
		
		//Assertion on status code
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//fetch and display header of response
		System.out.println("All header value"+response.getHeaders());
		
		//fetch specific header value
		System.out.println("Specific value "+response.getHeader("Date"));
		
		//fetch body content of response
		System.out.println("body value" +response.asString());
		System.out.println("pretty string" +response.asPrettyString());
		
		System.out.println("json path" +response.jsonPath().getString("data.first_name"));
		Assert.assertEquals(response.jsonPath().getString("data.first_name"), "Lakshmi");
	}
}
