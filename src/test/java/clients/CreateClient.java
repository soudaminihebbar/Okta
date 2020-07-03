package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

public class CreateClient {
    String clientId;

    final File clientdata = new File("clientdata.json");

    @Test
    public void createClient() {

        RestAssured.baseURI = "https://dev-853759.okta.com/oauth2/v1/clients";

        Response response = RestAssured
                .given()
                .header("Authorization", "SSWS 00UgR1Qm7xVZ7rJMnkQQgvnIopBc3sDzrm7Zj0wXkK")
                .contentType(ContentType.JSON)
                .body(clientdata)
                .post();
        JsonPath jsonPath = response.jsonPath();
        clientId = jsonPath.getString("client_id");
        response.then().assertThat().statusCode(201);
    }
}
