package main.test.steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static main.test.utils.StringParser.buildParameters;

public class ArtistSteps extends BaseSteps {
    SearchSteps searchSteps = new SearchSteps();

    public List<String> getArtistsID(String accessToken, String query){
        return searchSteps.getArtistInfo(accessToken, query).getBody().jsonPath().getList("artists.items.id");
    }

    public Response getArtist(String accessToken, String artistID){
        List<String> artistsIDs = new ArrayList<>();
        artistsIDs.add(artistID);
        return  getArtists(accessToken, artistsIDs);
    }

    public Response getArtists(String accessToken, List<String> artistsIds){

        String pathParam = "";
        String queryParam = "";

        if (artistsIds.size() == 1) {
            pathParam = artistsIds.get(0);
        } else {
            queryParam = buildParameters(artistsIds);
        }

        RestAssured.baseURI = SPOTIFY_API_URL;

        return RestAssured
                .given()
                .auth()
                .oauth2(accessToken)
                .pathParam("artistID", pathParam)
                .queryParameter("ids", queryParam)
                .log().all()
                .when()
                .get("/v1/artists/{artistID}")
                .then()
                .log().all()
                .extract()
                .response();
    }
}
