package main.test.runners;

import com.jayway.restassured.response.Response;
import main.test.steps.BaseSteps;
import main.test.utils.ReadConfigProperties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class GoogleBaseTest {

    private static final String GOOGLE_URL = "http://www.google.com";
    private static String USERNAME;
    private static String PASSWORD;

    private BaseSteps songBaseSteps;

    private ReadConfigProperties readConfigProperties;

    @BeforeClass
    public void setup(){
        readConfigProperties = new ReadConfigProperties();
        Map<String, String> properties = readConfigProperties.getConfigProperties(null);

        USERNAME = properties.get("username");
        PASSWORD = properties.get("password");

        songBaseSteps = new BaseSteps();
    }

    @Test
    public void firstTest(){
        assertEquals(1,1);
    }

    @Test
    public void testGetGoogleAndValidateResponseCode(){
        Response response = songBaseSteps.getSite(GOOGLE_URL);
        assertEquals(response.getStatusCode(), SC_OK, "Expected OK response code not returned");
    }
}