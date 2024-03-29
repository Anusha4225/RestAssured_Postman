package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	
	@Test
	public void PostCall() {
		RestAssured.baseURI = "http://localhost:7000"; 
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body("{\n" + 
				"	\"name\" : \"anusha\",\n" + 
				"	\"salary\" : \"9000\"\n" + 
				"}").post("/employees/create");
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
		int ActResponse = response.statusCode();
		int ExpResponse = 201;
		Assert.assertEquals(ActResponse, ExpResponse);
	}

}
