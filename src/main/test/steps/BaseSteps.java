package main.test.steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class BaseSteps {

    public BaseSteps(){ }

    public Response getSite(String url){
        return RestAssured.given()
                .when().log().all()
                .get(url)
                .then().log().all()
                .extract()
                .response();
    }

    public String getAccessTokenFromSpotify(String username, String password) throws UnsupportedEncodingException {
        String idSecret = username + ":" + password;
        String encoded = new String (Base64.encodeBase64(idSecret.getBytes()), "UTF-8");

        RestAssured.baseURI = "https://accounts.spotify.com/api";

        Response response = RestAssured
                .given()
                    //.header("Authorization","Basic " + bytesEncoded.toString())
                    .header("Authorization","Basic " + encoded)
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("grant_type","client_credentials")
                    .log().all()
                .when()
                    .post("token")
                .then()
                    .log().all()
                    .extract()
                    .response();

        return response.jsonPath().get("access_token");
    }
}