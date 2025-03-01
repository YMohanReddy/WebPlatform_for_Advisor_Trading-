package RestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io. restassured. module.jsv. JsonSchemaValidator. matchesJsonSchemaInClasspath;

public class JsonSchemaValidator {

	@Test
	public void schemaValidator() {
		baseURI = "https://reqres.in/";
		given().
		get("/api/users?page=2").
		then().
		assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200).
		log().all();
		//schema.json file is located at C:\Users\ybhas\git\WebPlatform_for_Advisor_Trading-\Web_Platform_For_Advisor_Trading\target\classes
		//we can't see this file from IDE
	}
}
