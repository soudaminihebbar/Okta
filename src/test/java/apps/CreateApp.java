package apps;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

public class CreateApp {
    File file = new File("createappdata.json");

    @Test
    public void createApp() {
        RestAssured.baseURI = "https://dev-853759.okta.com/api/v1/apps";

        RestAssured
                .given()
                .header("Authorization","SSWS 00UgR1Qm7xVZ7rJMnkQQgvnIopBc3sDzrm7Zj0wXkK")
                .contentType(ContentType.JSON)
                .body(file)
                .post()
                .then()
                .statusCode(200);
    }
}
