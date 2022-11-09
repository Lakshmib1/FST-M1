package org.rest.assured.project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put_Request {

String studentEndpoint = "https://thetestingworldapi.com/api/studentsDetails/3845789";
	
	@Test
	public void addStudentDetails() {
	
		RequestSpecification putRequest = RestAssured.given();
		putRequest
.body("{\"id\": 3845789,\"first_name\": \"Testing 1\",\"middle_name\": \"A\",  \"last_name\": \"BAS\", \"date_of_birth\": \"01-10-1982\"}");

		putRequest.header("Content-type","application/json");
		
		
		Response put = putRequest.put(studentEndpoint);
		System.out.println(put.statusCode());
		System.out.println(put.asPrettyString());
	}
}
