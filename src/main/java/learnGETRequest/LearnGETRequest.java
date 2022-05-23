package learnGETRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnGETRequest {
	
@Test
public void getemployeeId() {
	
	//Specify BaseURI
	
	RestAssured.baseURI="https://reqres.in/api/users";
	
	// Define Request object
	RequestSpecification httprequest = RestAssured.given();
	
	
	// Define response object
	Response response = httprequest.request(Method.GET,"/1");
	
	// Get the response
	
	String responsebody = response.getBody().asString();
	
	System.out.println("The response body is:"+responsebody);
	
	//Statuscode Validation
	
	int statusCode = response.getStatusCode();
	System.out.println("The status code is:" +statusCode);
	Assert.assertEquals(statusCode, 200);
	
	//Status line Validation
	
	String stline = response.getStatusLine();
	System.out.println("The Status line is:"+ stline);
    Assert.assertEquals(stline, "HTTP/1.1 200 OK");
    
    //String string_fn = response.jsonPath().getJsonObject("data.first_name").toString();
    
    String string_fn = response.jsonPath().getString("data.first_name");
    
    System.out.println("First name is:" +string_fn);
	
	
}

}
