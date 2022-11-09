package org.rest.assured.project;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request_queryparam {


String baseURL = "https://reqres.in/";
String path = "api/users/";
RequestSpecification requestSpecification;


	@BeforeMethod
	
	public void initMethod() {
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri(baseURL);
		requestSpecification.basePath(path);
		requestSpecification.queryParam("page", "2");
		
		System.out.println(requestSpecification.log().all());
	}
	
	@Test
	public void getStudentdetails() {
	
		
		
		Response response = requestSpecification.get();
		System.out.println(response.getStatusCode());
		System.out.println(response.asPrettyString());
		
	}
	}

