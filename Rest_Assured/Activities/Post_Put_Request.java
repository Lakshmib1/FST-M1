package org.rest.assured.project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.CoreMatchers.equalTo;
 

public class Post_Put_Request {

	
	String studentEndpoint = "https://thetestingworldapi.com/";
	
	@Test
	public void addStudentDetails() {
	
		//post with bdd implementation
		ValidatableResponse response = 
	            given()
.contentType(ContentType.JSON) // Set headers
.body("{\"id\": 1,\"first_name\": \"Testing new\",\"middle_name\": \"A\",  \"last_name\": \"BAS\", \"date_of_birth\": \"01-10-1982\"}")
.when()
.post(studentEndpoint+"api/studentsDetails") 
.then()
.statusCode(201);
		
	//	System.out.println(r
	//	System.out.println(response.asPrettyString());
	 
		
		
	}
}
