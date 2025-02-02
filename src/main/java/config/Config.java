package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public static String getAuthEndpoint(){
        return properties.getProperty("authEndpoint");
    }

    public static String getVideoGamesEndpoint() {
        return properties.getProperty("videoGamesEndpoint");
    }
}
