package main.test.runners;

import com.jayway.restassured.response.Response;
import main.test.model.Artists;
import main.test.spotify.model.Artist;
import main.test.steps.ArtistSteps;
import main.test.steps.SearchSteps;
import org.testng.annotations.Test;

import java.util.List;

import static main.test.utils.Logger.log;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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

        log("Get Artist list by list of IDs:");
        Response response1 = artistSteps.getArtists(CURRENT_TOKEN, artistsID);
        Artists artistsList = response1.getBody().as(Artists.class);


        log("Get Single Artist by ID:");
        Response response2 = artistSteps.getArtist(CURRENT_TOKEN, artistsID.get(0));
        Artist artist2 = response2.getBody().as(Artist.class);


        log("Artist Comparisons:"); //simple strings comparison to simulate comparing content of objects instead of comparing all fields
        assertTrue(artistsList.getArtist(0).compareIdAndName(artist2));
        assertFalse(artistsList.getArtist(1).compareIdAndName(artist2));
    }
}
