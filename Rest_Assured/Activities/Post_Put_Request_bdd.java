package org.rest.assured.project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 

public class Post_Put_Request_bdd {

	
	String studentEndpoint = "https://thetestingworldapi.com/";
	String firstname = "Jeevanesh";
	String middlename = "jeeva";
	String updatedmiddlename = "Reya";
	String lastname = "kamesh";
	String dob = "05-01-2011";
	String body = "{\"id\": ID,\"first_name\": \"FNAME\",\"middle_name\": \"MNAME\",  \"last_name\": \"LNAME\", \"date_of_birth\": \"DOB\"}"; 
	
	@Test
	public void addStudentDetails() {
	
		// *****POST REQUEST*********
		RequestSpecification response = RestAssured.given();
		response.header("content-type","application/json");
		response.body(body
				.replace("FNAME", firstname)
				.replace("MNAME", middlename)
				.replace("LNAME", lastname)
				.replace("DOB", dob)
				.replace("ID", "1"));
		Response post = response.post(studentEndpoint+"api/studentsDetails");
		System.out.println(post.statusCode());
		System.out.println(post.asPrettyString());

		//*****FETCH ID FROM POST RESPONSE*********
		String StudentID = post.jsonPath().getString("id");
		
		//*****GET REQUEST*********
		Response getresponse = RestAssured.get(studentEndpoint+"api/studentsDetails/"+StudentID);
		Assert.assertEquals(getresponse.getStatusCode(), 200);
		Assert.assertEquals(getresponse.jsonPath().getString("data.first_name"), firstname);
		
		//*****PUT REQUEST********
		
		RequestSpecification putresponse = RestAssured.given();
		putresponse.header("content-type","application/json");
		response.body(body
				.replace("FNAME", firstname)
				.replace("MNAME", updatedmiddlename)
				.replace("LNAME", lastname)
				.replace("DOB", dob)
				.replace("ID", StudentID));
		Response putresponse1 = response.put(studentEndpoint+"api/studentsDetails/"+StudentID);
		Assert.assertEquals(putresponse1.getStatusCode(), 200);
		
		//*****UPDATED GET REQUEST*********
				Response getresponse1 = RestAssured.get(studentEndpoint+"api/studentsDetails/"+StudentID);
				Assert.assertEquals(getresponse1.getStatusCode(), 200);
				Assert.assertEquals(getresponse1.jsonPath().getString("data.first_name"), firstname);
				Assert.assertEquals(getresponse1.jsonPath().getString("data.middle_name"), updatedmiddlename);
				System.out.println(getresponse1.asPrettyString());
				
		//*****DELETE REQUEST*********
				Response deleteresponse = RestAssured.delete(studentEndpoint+"api/studentsDetails/"+StudentID);
				Assert.assertEquals(deleteresponse.getStatusCode(), 200);
				System.out.println(deleteresponse.asPrettyString());
		
		//*****UPDATED GET REQUEST*********
				Response getresponse2 = RestAssured.get(studentEndpoint+"api/studentsDetails/"+StudentID);
				Assert.assertEquals(getresponse2.getStatusCode(), 200);
				Assert.assertEquals(getresponse2.jsonPath().getString("msg"), "No data Found");
				System.out.println(getresponse1.asPrettyString());
				
	}
}
