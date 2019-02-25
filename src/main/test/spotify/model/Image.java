package main.test.spotify.model;

import java.util.HashMap;

public class Image {

    int height;
    String url;
    int width;

    public Image() { }

    public Image(int height, String url, int width){
        this.height = height;
        this.url = url;
        this.width = width;
    }

    public Image(HashMap<String, Object> categoryIcon){
        this.height = (int) categoryIcon.get("height");
        this.url =  categoryIcon.get("url").toString();
        this.width =  (int) categoryIcon.get("width");
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
