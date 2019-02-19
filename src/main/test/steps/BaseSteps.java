package main.test.steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import main.test.utils.Logger;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class BaseSteps {

    private static final String SPOTIFY_LOGIN_URL = "https://accounts.spotify.com";
    static final String SPOTIFY_API_URL = "https://api.spotify.com";

    public Logger logger = new Logger();

    public String getAccessTokenFromSpotify(String username, String password) throws UnsupportedEncodingException {

        RestAssured.baseURI = SPOTIFY_LOGIN_URL;

        String idSecret = username + ":" + password;
        String encoded = new String (Base64.encodeBase64(idSecret.getBytes()), "UTF-8");

        Response response = RestAssured
                .given()
                    .header("Authorization","Basic " + encoded)
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("grant_type","client_credentials")
                    .log().all()
                .when()
                    .post("/api/token")
                .then()
                    .log().all()
                    .extract()
                    .response();

        return response.jsonPath().get("access_token");
    }
}