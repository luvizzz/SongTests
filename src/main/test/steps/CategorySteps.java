package main.test.steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class CategorySteps extends BaseSteps{

    public Response getBrowseCategories(String accessToken) {
        Map<String, String> params = new HashMap<>();
        params.clear();
        return getBrowseCategories(accessToken, params);
    }

    public Response getBrowseCategories(String accessToken, Map<String, String> params){

        RestAssured.baseURI = SPOTIFY_API_URL;

        return RestAssured
                .given()
                .auth()
                .oauth2(accessToken)
                .params(params)
                .log().all()
                .when()
                .get("/v1/browse/categories")
                .then()
                .log().all()
                .extract()
                .response();
    }
}
