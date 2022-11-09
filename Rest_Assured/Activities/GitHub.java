package org.rest.assured.project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHub {
	private String baseURI;
	public String SSHkey;
	int SSHKeyID;
	RequestSpecification requestSpec;
	
		// Set Base URL
	String ROOT_URI = "https://api.github.com";

	@BeforeClass
	public void setUp() {
	
		requestSpec = new RequestSpecBuilder()
					.setContentType(ContentType.JSON)
					.addHeader("Authorization","token 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")
					.setBaseUri("https://api.github.com").build();
	
	
	}
	
	@Test (priority = 1)
	public void PostReq() {
	    // Write the request body
	    String reqBody = "{\"title\": \"TestAPIKey\",\"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBvWIx6KzBp/A/kmxofhQko8Eqx/gmoO+PGwXYQw0s+O\" }"; 
	    		
	       Response response = 
	        given().spec(requestSpec)// Set headers
	        .body(reqBody).when().post("user/keys"); // Send POST request

	    // Print response of POST request
	    String body = response.getBody().asPrettyString();
	    System.out.println(body);
	    
	    SSHKeyID = response.then().extract().path("id");
	 // To assert success status code
	    response.then().statusCode(201);

	}
	
	@Test(priority = 2)
	public void getRequest()
	{
		 Response response = 
			        given().spec(requestSpec)// Set headers
			        .pathParam("keyId", SSHKeyID)
			        .when().get("/user/keys/{keyId}");
		 
		 String body = response.getBody().asPrettyString();
		    System.out.println(body);
		    
		    Reporter.log(body);
		 // To assert success status code
		    response.then().statusCode(200);
	}
	
	@Test(priority = 3)
	private void DeleteRequest() {
		 Response response =
		            given().spec(requestSpec)
		                    .pathParam("keyId", SSHKeyID)
		                    .when().delete("/user/keys/{keyId}");
		    String body = response.getBody().asPrettyString();
		    System.out.println(body);
		    Reporter.log(body);
		    response.then().statusCode(204);

	}
 
}
