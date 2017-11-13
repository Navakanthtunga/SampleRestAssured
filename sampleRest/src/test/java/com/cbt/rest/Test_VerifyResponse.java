package com.cbt.rest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import java.util.Map.Entry;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Test_VerifyResponse
{
	@BeforeMethod
	public void init()
	{
		baseURI="http://www.abof.com/service/suggest/top-searches";
	}
	//@Test
	public void testStatusInResponse()
	{
		given().when().get(baseURI).then().assertThat().statusCode(200).log().all();
		given().when().get(baseURI).then().assertThat().statusLine("HTTP/1.1 200 OK");
	}
	//@Test
	public void testHeaderInResponse()
	{
		given().when().get(baseURI).then().assertThat().header("Server", "Jetty(9.2.9.v20150224)");
		given().when().get(baseURI).then().assertThat().headers("Server", "Jetty(9.2.9.v20150224)","Content-Encoding","gzip");
		given().when().get(baseURI).then().assertThat().header("Content-Length", "184");
	}
	//@Test
	public void testBodyInResponse()
	{
		String resp=get(baseURI).asString();
		given().when().get(baseURI).then().assertThat().body(equalTo(resp));
	}
	@Test
	public void testCookieInResponse()
	{
		baseURI="http://www.abof.com/wcs/resources/store/10154/headerFooterLinks";
		Response resp=given().when().get(baseURI).then().extract().response();
		Map<String,String> entry=resp.getCookies();
		String prevCookie="0000VTAEsawlrfelv90yntAUBLS:1a1q7frst";
		String cookiename="";
		String cookieValue="";
		for(Map.Entry<String, String> cookie : entry.entrySet())
		{
			cookiename=cookie.getKey();
			cookieValue=cookie.getValue();
			System.out.println("------cookie name------" + cookie.getKey());
			System.out.println("------cookie value------" + cookie.getValue());
		}
		given().when().get(basePath).then().assertThat().cookie(cookiename,cookieValue);
	}

}
