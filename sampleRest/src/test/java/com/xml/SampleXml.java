package com.xml;

import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.ParserConfigurationException;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class SampleXml {
	@Test(priority=1,enabled=false,description="Verify 'Get' request - considering 'xml' as output with valid api key")
	public void testGetRequestWithValidKey() throws SAXException, IOException, ParserConfigurationException{
		String lat_key="lat";
		String lat_value="35";
		String lon_key="lon";
		String lon_value="139";
		String mode_key="mode";
		String mode_value="xml";
		String appId_key="APPID";
		String appID_value="92cc96ecfe265f251d814b66592a7848";
		Response rsp1=given().get("http://api.openweathermap.org/data/2.5/weather?"+lat_key+"="+lat_value+"&"+lon_key+"="+lon_value+"&"+mode_key+"="+mode_value+"&"+appId_key+"="+appID_value);
		System.out.println(rsp1.asString());
		try(  PrintWriter out = new PrintWriter( "restApiResponse.xml" )  ){
			out.println(rsp1.asString());
		}
		System.out.println("Status code - "+rsp1.statusCode());
		// Reading the data from xml
		//ReadfromXML.getAttributeData(".//restApiResponse.xml", "direction", "value");
//		ReadfromXML.getAttributeData(".//restApiResponse.xml", "direction", "code");
//		ReadfromXML.getAttributeData(".//restApiResponse.xml", "direction", "name");
	}
	@Test(priority=2,enabled=true,description="Verify 'Get' request - considering 'xml' as output with valid api key")
	public void testGetRequestWithValidKey2() throws SAXException, IOException, ParserConfigurationException{
		String lat_key="lat";
		String lat_value="35";
		String lon_key="lon";
		String lon_value="139";
		String mode_key="mode";
		String mode_value="xml";
		String appId_key="APPID";
		String appID_value="92cc96ecfe265f251d814b66592a7848";
		Response rsp1=given().
				 param(lat_key, "lat").
				 param(lat_value, "35").
				 param(lon_key, "lon").
				 param(lon_value, "139").
				 param(mode_key, "mode").
				 param(mode_value, "xml").
				 param(appId_key, "APPID").
				 param(appID_value, "92cc96ecfe265f251d814b66592a7848").
				get("http://api.openweathermap.org/data/2.5/weather?lat_key");
		System.out.println(rsp1.asString());
		try(  PrintWriter out = new PrintWriter( "restApiResponse.xml" )  ){
			out.println(rsp1.asString());
		}
		System.out.println("Status code - "+rsp1.statusCode());
		// Reading the data from xml
//		ReadfromXML.getAttributeData(".//restApiResponse.xml", "direction", "value");
//		ReadfromXML.getAttributeData(".//restApiResponse.xml", "direction", "code");
//		ReadfromXML.getAttributeData(".//restApiResponse.xml", "direction", "name");
	}
}
