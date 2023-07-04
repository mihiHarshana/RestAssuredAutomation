import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utils.Utilities;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class TestHttpGetRequest {

	@BeforeTest
	public void setup() {
		baseURI = "https://api.restful-api.dev";
		
	}

	@Test
	public void getAllObjects() {

		given().get("/").

				then().statusCode(200);

	}

	@Test
	public void getSingleObject() {
		given().
			get("/objects/7").

		then().
			body("id", equalTo("7")).and().
			body("name", equalTo("Apple MacBook Pro 16"));
	}

	@Test
	public void postSingleObject() {
		Utilities utils = new Utilities();

		given().
			contentType(ContentType.JSON).
			header("Content-Type", "application/json").
			body(utils.createJsonObject().toString()).

		when().
			post("/objects").

		then().
		statusCode(200).
		log().all();

	}
	
}
