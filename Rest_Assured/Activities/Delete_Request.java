package org.rest.assured.project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_Request {

String studentEndpoint = "https://thetestingworldapi.com/api/studentsDetails/3845790";
	
	@Test
	public void addStudentDetails() {
	
		Response delete = RestAssured.delete(studentEndpoint);
		System.out.println(delete.statusCode());
		System.out.println(delete.asPrettyString());
		
	}
}
