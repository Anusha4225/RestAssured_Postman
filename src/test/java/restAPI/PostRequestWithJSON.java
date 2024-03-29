package restAPI;



import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJSON {

	@Test
	public void PostCall() {
		RestAssured.baseURI = "http://localhost:7000"; 
		RequestSpecification request = RestAssured.given();
		JSONObject PostBody = new JSONObject();
		
		PostBody.put("name", "ViratKohli");
		PostBody.put("salary", 7800);
		
		
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(PostBody.toString()).post("/employees/create");
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
		int ActResponse = response.statusCode();
		int ExpResponse = 201;
		Assert.assertEquals(ActResponse, ExpResponse);
		
		Assert.assertTrue(ResponseBody.contains("ViratKohli"));
		
		JsonPath jpath = response.jsonPath();
		String ActName = jpath.get("name");
		
		String ExpName = "ViratKohli";
		Assert.assertEquals(ActName, ExpName);
	}

}
