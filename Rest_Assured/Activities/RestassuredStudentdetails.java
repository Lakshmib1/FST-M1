package org.rest.assured.project;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestassuredStudentdetails {

	
	String studentEndpoint = "https://thetestingworldapi.com/api/studentsDetails/3845789";
	
	@Test
	public void getStudentDetails() {
	
		Response response = RestAssured.get(studentEndpoint);
		System.out.println("Status code "+response.getStatusCode());
		
		//fetch and display header of response
		System.out.println("All header value"+response.getHeaders());
		
		//fetch specific header value
		System.out.println("Specific value "+response.getHeader("Date"));
		
		//fetch body content of response
		System.out.println("body value" +response.asString());
		System.out.println("pretty string" +response.asPrettyString());
		
	}
}
