import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utils.MobilePhone;
import utils.Utilities;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class TestHttpGetRequest {
	String objectId;

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
		given().get("/objects/7").

				then().body("id", equalTo("7")).and().body("name", equalTo("Apple MacBook Pro 16"));
	}

	@Test(priority = 1)
	public void postSingleObject() {
	
		JSONObject json = new JSONObject();
		json.put("year", 2023);
		json.put("price", 25000);

		MobilePhone mobile = new MobilePhone(1, "Mobile phone 1", json);

		objectId = given().contentType(ContentType.JSON).header("Content-Type", "application/json").body(mobile).

				when().post("/objects").jsonPath().getString("id");

	}

	@Test(dependsOnMethods = { "postSingleObject" })
	public void updateObject() {

		JSONObject json = new JSONObject();
		json.put("year", 2024);
		json.put("price", 8500);
		MobilePhone mobile = new MobilePhone("Mobile phone 1", json);
		given()
			.contentType(ContentType.JSON)
			.header("Content-Type", "application/json")
			.body(mobile)

		.when()
			.put("https://api.restful-api.dev/objects/" + objectId)
				
		.then()
		.statusCode(200).log().all();

	}

	
	@Test(dependsOnMethods = { "updateObject" })
	public void deleteObject() {

		given()
			.contentType(ContentType.JSON)
			.header("Content-Type", "application/json")

		.when().
			delete("https://api.restful-api.dev/objects/" + objectId)

		.then()
			.statusCode(200).log().all();

	}
	 

}
