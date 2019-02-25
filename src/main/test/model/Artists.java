package main.test.model;

import main.test.spotify.model.Artist;

import java.util.List;

public class Artists {
    private List<Artist> artists;

    Artists() { }

    public List<Artist> getArtists() {
        return artists;
    }

    public Artist getArtist(int index) {
        return artists.get(index);
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
