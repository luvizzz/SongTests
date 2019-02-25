package main.test.runners;

import main.test.steps.BaseSteps;
import main.test.utils.Logger;
import main.test.utils.ReadConfigProperties;
import org.testng.annotations.BeforeSuite;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class SpotifyBaseTests {

    private static String USERNAME;
    private static String PASSWORD;
    static String CURRENT_TOKEN;

    BaseSteps songBaseSteps;
    Logger logger;

    private ReadConfigProperties readConfigProperties;

    @BeforeSuite
    public void setup() throws UnsupportedEncodingException {
        readConfigProperties = new ReadConfigProperties();
        Map<String, String> properties = readConfigProperties.getConfigProperties();

        USERNAME = properties.get("username");
        PASSWORD = properties.get("password");

        songBaseSteps = new BaseSteps();
        logger = new Logger();
        CURRENT_TOKEN = songBaseSteps.getAccessTokenFromSpotify(USERNAME, PASSWORD);
    }
}