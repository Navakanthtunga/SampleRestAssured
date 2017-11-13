package com.cbt.rest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.testng.annotations.Test;
import groovy.time.BaseDuration.From;
import groovy.transform.stc.FromString;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
public class GetResponseAsList {
	@Test
	public void getResponseList()
	{
		String response=get("http://localhost:3000/posts/").asString();
		System.out.println(" ---Got resposne-------" + response);
		JsonPath jsonPath=new JsonPath(response);
		List<String> authorList=jsonPath.get("author");
		for(String author:authorList)
		{
			System.out.println("-------------author ----------" + author);
		}
	}
	@Test
	public void testLengthOfResponse()
	{
		ValidatableResponse response=given().when().get("http://localhost:3000/posts/").then().body("author[0].length()", equalTo(17));
	}
	@Test
	public void testLengthofAuthor()
	{
		String response=get("http://localhost:3000/posts/").asString();
		JsonPath jsonPath=new JsonPath(response);
		List<String> authorList=jsonPath.get("author");
	}
}
