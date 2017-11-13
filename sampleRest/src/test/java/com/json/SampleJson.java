package com.json;


import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class SampleJson {
	@Test(priority=1,enabled=true)
	public void tc_01(){
	String expectedOutput="light intensity drizzle";
	Response response=given().
			param("q", "London").
			param("appid", "b1b15e88fa797225412429c1c50c122a1").
			get("http://openweathermap.org/data/2.5/weather?q");
	System.out.println("response"+response.asString());
	String actualOutput=response.then().contentType(ContentType.JSON).extract().path("weather[0].description");
	System.out.println("Response generated is ");
	System.out.println(actualOutput);
	if(actualOutput.equalsIgnoreCase(expectedOutput)){
		Assert.assertEquals(actualOutput, expectedOutput);
	}
	else
		System.out.println("Data Mismatching");
	}
}
