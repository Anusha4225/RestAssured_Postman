package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	

		@Test
		public void PostCall() {
		
			Map<String,Object> PostBody = new HashMap<String,Object>();
			PostBody.put("name", "alluarjun");
			PostBody.put("salary", 7900);
			
			RestAssured.given()
				.baseUri("http://localhost:7000")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(PostBody)
				
				.when()
				.post("/employees/create")
				.then()
				.statusCode(201)
				.log()
				.all();
		}
}

