package clients;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class DeleteClient{

    CreateClient createClient = new CreateClient();

    @Test
    public void deleteClient() {


        RestAssured.baseURI = "https://dev-853759.okta.com/oauth2/v1/clients";

        RestAssured
                .given()
                .header("Authorization", "SSWS 00UgR1Qm7xVZ7rJMnkQQgvnIopBc3sDzrm7Zj0wXkK")
                .delete(createClient.clientId)
                .then()
                .statusCode(204);

    }
}
