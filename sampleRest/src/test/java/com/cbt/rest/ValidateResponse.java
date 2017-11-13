package com.cbt.rest;

import org.testng.annotations.Test;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ValidateResponse {
	@Test
	public void testValidateResponse(){
		ValidatableResponse resp=
				given().when().get("http://www.abof.com/service/suggest/top-searches").then().log().body();
		System.out.println("--------Respnonse---------- " + resp);
	}
}
