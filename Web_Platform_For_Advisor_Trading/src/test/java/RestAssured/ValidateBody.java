package RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers .*;

import org.testng.annotations.Test;

public class ValidateBody {

	@Test
	public void testResponseBody() {
		baseURI = "https://reqres.in/";
		given().
			get("/api/users?page=2").
			then().
			body("data[1].id", equalTo(8))
			.log().all();
	}
	
	@Test
	public void testResponseBodywithHasItems() {
		baseURI = "https://reqres.in/";
		given().
			get("/api/users?page=2").
			then().
			body("data[3].first_name", equalTo("Byron")).
			body("data.first_name", hasItems("Byron", "George", "George1"))
			.log().all();
	}
}
