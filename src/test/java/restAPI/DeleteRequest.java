package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {


	@Test
	public void PostCall() {
		RestAssured.baseURI = "http://localhost:7000"; 
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("/employees/10");
		
		int ActResponse = response.statusCode();
		int ExpResponse = 200;
		Assert.assertEquals(ActResponse, ExpResponse);
	
	}
}
