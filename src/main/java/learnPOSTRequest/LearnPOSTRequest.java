package learnPOSTRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnPOSTRequest {
	
	
@Test
public void createUser() {
	
	RestAssured.baseURI="https://gorest.co.in/public/v1/users";
	RequestSpecification httprequest = RestAssured.given();
	String token ="6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216";
	
	JSONObject requestparm = new JSONObject();
	
	requestparm.put("name","Mayori Doha05");
	requestparm.put("email","doha_mayoori05@franeki.bi");
	requestparm.put("gender","Female");
	requestparm.put("status","Active");
	
	httprequest.header("Content-Type","application/json");
	//httprequest.header("Authorization","Bearer 6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216")
	httprequest.header("Authorization","Bearer "+token) ;
	httprequest.body(requestparm.toJSONString());
	
	Response response = httprequest.request(Method.POST);
	
	String responseBody = response.getBody().asString();
	
	System.out.println("The response body is:"+responseBody);
	
	//Statuscode Validation
	
		int statusCode = response.getStatusCode();
		System.out.println("The status code is:" +statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//Status line Validation
		
		String stline = response.getStatusLine();
		System.out.println("The Status line is:"+ stline);
	    Assert.assertEquals(stline, "HTTP/1.1 201 Created");
	
	
	
}

}
