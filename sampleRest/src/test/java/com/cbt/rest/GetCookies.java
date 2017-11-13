package com.cbt.rest;

import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import org.testng.annotations.Test;

public class GetCookies {
	@Test
	public void getConeectionStatus()
	{
		Response resp=given().when().get("http://www.abof.com/wcs/resources/store/10154/headerFooterLinks");
		System.out.println("-----------------Response----------" + resp);
		Map<String, String> cookies=resp.getCookies();
		for(Map.Entry<String,String> entry: cookies.entrySet() )
		{
			System.out.println("-----------cookie key------" + entry.getKey());
			System.out.println("-----------cookie value-----" + entry.getValue());
		}
		String cookIDValue=resp.getCookie("JSESSIONID");
		System.out.println("--------value of cookies JESSION ID--------" + cookIDValue);
		Response resp1=given().when().get("http://hn.inspectlet.com/ginit/1772480617");
		System.out.println("-----------------Response----------" + resp1);
		Cookie cookieDetails=resp1.getDetailedCookie("_cfduid");
		System.out.println(" ------does cookie have expiry date " + cookieDetails.hasExpiryDate());
		System.out.println(" ------does cookie have expiry date " + cookieDetails.getExpiryDate());
	}
}
