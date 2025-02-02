package tests;

import io.qameta.allure.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.GameService;

public class GameTest {
    @Test
    @AllureId("101")
    @Story("Retrieve all games")
    @Description("Fetch all video games and verify response status code is 200")
    @Severity(SeverityLevel.CRITICAL)
    public void testGetAllGames() {
        Response response = GameService.getAllGames();
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertFalse(response.jsonPath().getList("id").isEmpty());
    }

    @Test
    public void testGetGameById() {
        Response response = GameService.getGameById(1);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertTrue(response.getBody().asString().contains("game"));
    }
}
