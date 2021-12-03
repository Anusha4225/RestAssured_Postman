package restAPI;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {

	

	@Test
	public void PostCall() {
		RestAssured.baseURI = "http://localhost:7000"; 
		RequestSpecification request = RestAssured.given();
		JSONObject PostBody = new JSONObject();
		
		PostBody.put("name", "James");
		PostBody.put("salary", 7800);
		
		
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(PostBody.toString()).put("/employees/10");
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
		int ActResponse = response.statusCode();
		int ExpResponse = 200;
		Assert.assertEquals(ActResponse, ExpResponse);
		
	}
}
