package org.rest.assured.project;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Request_external_json_file {
	
	RequestSpecification requestSpecification;
	String baseURI = "https://thetestingworldapi.com/";
	String basePath = "api/studentsDetails";
	
	@BeforeMethod
	public void initmethod() {
		File f = new File("./Project Request/putrequest.json");
		requestSpecification = RestAssured.given();
		requestSpecification.header("content-type","application/json");
		requestSpecification.baseUri(baseURI);
		requestSpecification.basePath(basePath);
		requestSpecification.body(f);
		System.out.println(requestSpecification.log().all());
		
	}
	
	@Test
	public void putrequest()
	{
		Response post = requestSpecification.post();
		System.out.println(post.statusCode());
		System.out.println(post.asPrettyString());
		
		
	}
}
