package main.test.runners;

import main.test.steps.BaseSteps;
import main.test.utils.Logger;
import main.test.utils.ReadConfigProperties;
import org.testng.annotations.BeforeClass;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class SpotifyBaseTests {

    private static String USERNAME;
    private static String PASSWORD;
    String CURRENT_TOKEN;

    BaseSteps songBaseSteps = new BaseSteps();;
    Logger logger = new Logger();

    private ReadConfigProperties readConfigProperties;

    @BeforeClass
    public void setup() throws UnsupportedEncodingException {
        readConfigProperties = new ReadConfigProperties();
        Map<String, String> properties = readConfigProperties.getConfigProperties();

        USERNAME = properties.get("username");
        PASSWORD = properties.get("password");

        CURRENT_TOKEN = songBaseSteps.getAccessTokenFromSpotify(USERNAME, PASSWORD);
    }
}