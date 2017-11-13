package com.cbt.rest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class ValidatePUT {
	@Test
	public void testValidateResponse(){
		given().when().put("http://www.abof.com/wcs/resources/store/10154/wishlist/2941526?addItem=true").then().assertThat().body("request.userid", equalTo("20503485"));
	}
	@Test
	public void testValidateDelete(){
		given().when().delete("http://www.abof.com/wcs/resources/store/10154/wishlist/2941526?itemId=16538896").then().assertThat().statusCode(200);
	}
}
