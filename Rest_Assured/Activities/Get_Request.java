package org.rest.assured.project;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request {


String baseURL = "https://reqres.in/";
String path = "api/users/";
RequestSpecification requestSpecification;

@BeforeMethod
public void initmethod() {
	requestSpecification = RestAssured.given();
	requestSpecification.baseUri(baseURL);
	requestSpecification.basePath(path);
	requestSpecification.pathParam("ID", 2);
}

	
	@Test
	public void getStudentdetails() {
	
		
		
		System.out.println(requestSpecification.log().all());
		Response response = requestSpecification.get("{ID}");
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		
	}
}
