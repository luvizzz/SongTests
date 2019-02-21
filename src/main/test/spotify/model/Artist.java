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

    /*
    public Artist(HashMap<String, Object> artist) {
        this.genres = new ArrayList<>();
        this.images = new ArrayList<>();

        //this.external_urls = artist.get("external_urls.spotify").as(ExternalURL.class);
        this.followers = new Followers(artist.get("followers.href").toString(), (int) artist.get("followers.total"));
        this.genres = (List<String>) artist.get("genres");
        this.href = artist.get("href").toString();
        this.id = artist.get("id").toString();
        this.images = (List<Image>) artist.get("images");
        this.name = artist.get("name").toString();
        this.popularity = (int) artist.get("popularity");
        this.type = artist.get("type").toString();
        this.uri = artist.get("uri").toString();
    }*/

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
}
