package com.cbt.rest;

import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class ValidateHasItems {
	@Test
	public void testValidateResponse(){
		given().when().get("http://www.abof.com/service/suggest/top-searches").then().statusCode(200).assertThat().body("suggestion", hasItems("skult","shoes","mens skult") );
	}
}
