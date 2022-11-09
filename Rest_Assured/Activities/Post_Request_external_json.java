package org.rest.assured.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Request_external_json {
	
	RequestSpecification requestSpecification;
	String baseURI = "https://thetestingworldapi.com/";
	String basePath = "api/studentsDetails";
	
	@BeforeMethod
	public void initmethod() throws IOException {
		String inputData = "";
		File f = new File("./Project Request/putrequest.json");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String readLine = br.readLine();
		
		while(readLine!=null) {
			inputData = inputData+readLine;
			readLine = br.readLine();
		}
		
		requestSpecification = RestAssured.given();
		requestSpecification.header("content-type","application/json");
		requestSpecification.baseUri(baseURI);
		requestSpecification.basePath(basePath);
		requestSpecification.body(inputData);
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
