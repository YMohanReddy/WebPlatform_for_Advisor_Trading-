package RestAssured;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteRequest {
	@Test
	public void PutRequest() {
		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "test");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().put("/users/2").then().statusCode(200).log().all();
	}
	@Test
	public void PatchRequest() {
		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "test");
		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in/api";
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch("/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void DeleteRequest() {
		baseURI = "https://reqres.in/api";
		when().delete("/users/2").then().statusCode(204).log().all();
	}
}
