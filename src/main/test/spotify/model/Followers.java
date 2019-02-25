package main.test.spotify.model;

import com.beust.jcommander.internal.Nullable;

import java.util.HashMap;

public class Followers {
    @Nullable
    String href;
    
    int total;

    public Followers() { }

    public Followers(@Nullable String href, int total) {
        this.href = href;
        this.total = total;
    }

    public Followers(HashMap<String, Object> followers) {
        this.href = followers.get("href").toString();
        this.total= (int) followers.get("total");
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
