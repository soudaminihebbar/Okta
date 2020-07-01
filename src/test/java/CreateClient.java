import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

public class CreateClient {

    File clientdata = new File("clientdata.json");

    @Test
    public void createClient() {

        RestAssured.baseURI = "https://dev-853759.okta.com/oauth2/v1/clients";

        RestAssured
                .given()
                .header("Authorization", "SSWS 00UgR1Qm7xVZ7rJMnkQQgvnIopBc3sDzrm7Zj0wXkK")
                .contentType(ContentType.JSON)
                .body(clientdata)
                .post()
        .then()
        .statusCode(201);
    }
}
