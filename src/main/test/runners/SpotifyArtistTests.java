package main.test.runners;

import com.jayway.restassured.response.Response;
import main.test.spotify.model.Artist;
import main.test.steps.ArtistSteps;
import main.test.steps.SearchSteps;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SpotifyArtistTests extends SpotifyBaseTests {
    ArtistSteps artistSteps = new ArtistSteps();
    SearchSteps searchSteps = new SearchSteps();

    @Test
    public void getRedHotChilliPeppers() {
        Response response = searchSteps.getArtistInfo(CURRENT_TOKEN, "Red Hot Chilli Peppers");
        assertEquals(response.getStatusCode(), SC_OK, "Expected OK response code not returned");
    }

    @Test
    public void getArtists() {
        List<String> artistsID = artistSteps.getArtistsID(CURRENT_TOKEN, "Red Hot Chilli Peppers");

        Response response1 = artistSteps.getArtists(CURRENT_TOKEN, artistsID);
        List<Artist> artistsList = new ArrayList<>();
                response1.getBody().jsonPath().getList("artists", Artist.class)
                .forEach(artist -> artistsList.add(artist));

        Response response2 = artistSteps.getArtist(CURRENT_TOKEN, artistsID.get(0));
        Artist artist2 = response2.getBody().jsonPath().get();

        assertTrue(artistsList.get(0).equals(artist2));
        assertFalse(artistsList.get(1).equals(artist2));
        //validate response1.getBody().jsonPath().get("artists[0]") == response2
        //validate response1.getBody().jsonPath().get("artists[1]") != response2
    }
}
