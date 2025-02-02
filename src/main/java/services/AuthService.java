package services;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private static String token;

    public static String getAuthToken() {
        if (token == null) {
            Map<String, String> credentials = new HashMap<>();
            credentials.put("username", "admin");
            credentials.put("password", "admin");

            Response response = RestAssured
                    .given()
                    .contentType("application/json")
                    .body(credentials)
                    .post(Config.getBaseUrl() + Config.getAuthEndpoint());

            token = response.jsonPath().getString("token");
        }
        return token;
    }
}
