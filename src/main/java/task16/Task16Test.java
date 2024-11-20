package task16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Task16Test {
    private static final String KEY = "938d381737f3d3ab2926f092c7b7edfb";
    private static final String TOKEN = "ATTA2b105a0263ad450bf4e5dd60e039cb80265e657f9b119bc5e6edff18c68d84123BD945DE";

    @Test
    void trelloTest() {
        // Create new board
        Response createBoardResponse = given()
                .queryParam("name", "TestBoardGG")
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/boards/")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String boardID = createBoardResponse.jsonPath().getString("id");

        // Get lists from board
        Response listsResponse = given()
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .when()
                .get("https://api.trello.com/1/boards/" + boardID + "/lists")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        // Get first list ID
        String listID = listsResponse.jsonPath().getString("[0].id");

        // Create new card
        Response createCardResponse = given()
                .queryParam("name", "TestExampleCard1")
                .queryParam("desc", "Example description")
                .queryParam("idList", listID)
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/cards")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();

        String cardID = createCardResponse.jsonPath().getString("id");

        // Update card description
        given()
                .queryParam("desc", "New example description")
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .put("https://api.trello.com/1/cards/" + cardID)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);

        // Delete card
        given()
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .delete("https://api.trello.com/1/cards/" + cardID)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }
}