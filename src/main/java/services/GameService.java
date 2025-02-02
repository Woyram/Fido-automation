package services;

import config.Config;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GameService {

    public static Response getAllGames() {
        return given()
                .baseUri(Config.getBaseUrl())
                .header("Authorization", "Bearer " + AuthService.getAuthToken())
                .when()
                .get(Config.getVideoGamesEndpoint());
    }

    public static Response getGameById(int gameId) {
        return given()
                .baseUri(Config.getBaseUrl())
                .header("Authorization", "Bearer " + AuthService.getAuthToken())
                .pathParam("id", gameId)
                .when()
                .get(Config.getVideoGamesEndpoint() + "/" + gameId);
    }
}
