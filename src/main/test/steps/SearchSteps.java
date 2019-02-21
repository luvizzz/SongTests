package main.test.steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class SearchSteps extends BaseSteps{

    public Response getArtistInfo(String accessToken, String query){
        return getSearchInfo(accessToken, query, "artist");
    }

    public Response getSearchInfo(String accessToken, String query, String type){

        RestAssured.baseURI = SPOTIFY_API_URL;

        return RestAssured
                .given()
                .auth()
                .oauth2(accessToken)
                .queryParam("q", query)
                .queryParam("type", type)
                .log().all()
                .when()
                .get("/v1/search")
                .then()
                .log().all()
                .extract()
                .response();
    }
}
