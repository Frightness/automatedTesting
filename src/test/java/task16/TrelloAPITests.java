package task16;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class TrelloAPITests {
    private final String apiKey = "938d381737f3d3ab2926f092c7b7edfb";
    private final String apiToken = "ATTA2b105a0263ad450bf4e5dd60e039cb80265e657f9b119bc5e6edff18c68d84123BD945DE";

    @Test
    public void createBoardTest() {
        String boardName = "Test Board";

        Response response = given()
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .queryParam("name", boardName)
                .when()
                .post("/boards")
                .then()
                .statusCode(200)
                .extract().response();

        BoardResponse boardResponse = response.as(BoardResponse.class);
        assert boardResponse.getName().equals(boardName);
    }
}
