package main.test.spotify.model;

import java.util.HashMap;

public class ExternalURL {
    String spotify;

    public ExternalURL() { }

    public ExternalURL(String url) {
        this.spotify = url;
    }

    public ExternalURL(HashMap<String, Object> url){
        this.spotify =  url.get("spotify").toString();
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }
}
