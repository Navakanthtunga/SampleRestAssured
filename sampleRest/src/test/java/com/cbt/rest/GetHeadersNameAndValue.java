package com.cbt.rest;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class GetHeadersNameAndValue {
	@Test
	public void getConectionStatus()
	{
		Response resp=given().when().get("http://www.abof.com/wcs/resources/store/10154/headerFooterLinks");
		System.out.println("-----------------Response----------" + resp);
		String headers=resp.getHeader("Connection");
		System.out.println("--------Header connection status--------" + headers);
		Headers listHeaders=resp.getHeaders();
		for(Header head:listHeaders)
		{
			System.out.println("-------Name----" + head.getName());
			System.out.println("-------Value----" + head.getValue());
		}
		String date=resp.getHeader("Date");
		System.out.println("---------Date is " + date);
	}
}
