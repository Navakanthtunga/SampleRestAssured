package com.cbt.rest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class ValidateEqualsTo {
	private static final int TEST_TIMEOUT = 60000;
	private String[] group={"get"};
	static {
		String group=System.getProperty("group");
	}
	@Test(groups={"get"})
	public void testValidateResponse(){
		given().when().get("http://www.abof.com/service/suggest/top-searches").then().statusCode(200).assertThat().body("suggestion[0]", equalTo("skult")).body("suggestion[6]", equalTo("shoes"));
	}
	@Test(groups={"group"})
	public void testExractAuthor(){
		Object obj=when().get("http://localhost:3000/posts/").then().statusCode(200).assertThat().body("id[0]",equalTo("101")).extract().path("author");
		System.out.println("---------101 ------autohr------" + obj.toString());
	}
	@Test(groups={"group"})
	public void testExractTitle(){
		Object obj=when().get("http://localhost:3000/posts/").path("title[0]");
		System.out.println("---------101 ------title------" + obj.toString());
	}
	@Test(groups={"group"})
	public void testJsonPath(){
		Object obj=when().get("http://localhost:3000/posts/").andReturn().jsonPath().getString("id[0]");
		System.out.println("---------101 ------title------" + obj.toString());
	}
}
