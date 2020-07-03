package clients;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteClient {

    @Test
    public void deleteClient() throws IOException {
        CreateClient createClient = new CreateClient();
        createClient.createClient();
        String clientId = createClient.clientId;
        RestAssured.baseURI = "https://dev-853759.okta.com/oauth2/v1/clients";

        RestAssured
                .given()
                .header("Authorization", "SSWS 00UgR1Qm7xVZ7rJMnkQQgvnIopBc3sDzrm7Zj0wXkK")
                .delete(clientId)
                .then()
                .statusCode(204);

    }
}
