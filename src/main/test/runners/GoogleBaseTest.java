package main.test.runners;

import com.jayway.restassured.response.Response;
import main.test.steps.BaseSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class GoogleBaseTest {

    private static final String GOOGLE_URL = "http://www.google.com";

    private BaseSteps songBaseSteps;

    @BeforeClass
    public void setup(){
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