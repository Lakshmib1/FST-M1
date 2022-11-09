package org.rest.assured.project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Request_BDD {

	
	String studentEndpoint = "https://thetestingworldapi.com/api/studentsDetails";
	
	@Test
	public void addStudentDetails() {
	
		RequestSpecification postRequest = RestAssured.given();
		postRequest
.body("{\"id\": 1,\"first_name\": \"Testing new\",\"middle_name\": \"A\",  \"last_name\": \"BAS\", \"date_of_birth\": \"01-10-1982\"}");

		postRequest.header("Content-type","application/json");
		Response post = postRequest.post(studentEndpoint);
		System.out.println(post.statusCode());
		System.out.println(post.asPrettyString());
	}
}
