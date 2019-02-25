package main.test.spotify.model;

import java.util.List;

public class Artist {
    ExternalURL external_urls;
    Followers followers;
    List<String> genres;
    List<Image> images;
    String href;
    String id;
    String name;
    String type;
    String uri;
    int popularity;

    public Artist(){ }

    public Artist(
            ExternalURL external_urls,
            Followers followers,
            List<String> genres,
            String href,
            String id,
            List<Image> images,
            String name,
            int popularity,
            String type,
            String uri) {
        this.external_urls = external_urls;
        this.followers = followers;
        this.genres = genres;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.popularity = popularity;
        this.type = type;
        this.uri = uri;
    }

    public ExternalURL getExternal_urls() {
        return external_urls;
    }

    public void setExternal_urls(ExternalURL external_urls) {
        this.external_urls = external_urls;
    }

    public Followers getFollowers() {
        return followers;
    }

    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public boolean compareIdAndName(Artist artist2) {
        return (this.id.equals(artist2.getId()) && this.name.equals(artist2.getName()));
    }
}
