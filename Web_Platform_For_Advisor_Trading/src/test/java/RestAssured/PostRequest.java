package RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequest {
	@Test
	public void mapToJson() {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("name", "Raghav");
	map.put("job", "Teacher");
	System.out.println(map);
	JSONObject request = new JSONObject(map);
	System.out.println(request.toJSONString());
	}
	
	@Test
	public void addDataInJson() {
	JSONObject request = new JSONObject();
	request.put("name", "Raghav");
	request.put("job", "test");
	System.out.println(request.toJSONString());
	
	baseURI = "https://reqres.in/api";
	given().
	header("Content-Type","application/json").
	contentType(ContentType.JSON).
	accept(ContentType.JSON).
	body(request.toJSONString()).
	when().
		post("/users").
		then().
		statusCode(201).
		log().all();
	}
	

}
