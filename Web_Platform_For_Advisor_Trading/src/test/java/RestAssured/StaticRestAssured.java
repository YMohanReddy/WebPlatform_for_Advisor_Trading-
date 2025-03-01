package RestAssured;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class StaticRestAssured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		baseURI = "https://reqres.in/";
		given().get("/api/users?page=2")
		.then().statusCode(200);
		System.out.println("In this program we made RestAssured. * as static, so that all the methods in than can"
				+ "be accessed directly without importing separately");
	}

}
