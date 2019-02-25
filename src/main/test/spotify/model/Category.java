package main.test.spotify.model;

import com.jayway.restassured.response.Response;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static main.test.utils.Logger.log;

public class Category {
    String href;
    List<Image> icons;
    String id;
    String name;

    public Category(){
        icons = new ArrayList<>();
    }

    public Category(String href, List<Image> icons, String id, String name) {
        this.href = href;
        this.icons = icons;
        this.id = id;
        this.name = name;
    }

    public Category(HashMap<String, Object> category) {
        this.icons = new ArrayList<>();

        this.href = category.get("href").toString();
        this.icons = (List<Image>) category.get("icons");
        this.id = category.get("id").toString();
        this.name = category.get("name").toString();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Image> getIcons() {
        return icons;
    }

    public void setIcons(List<Image> icons) {
        this.icons = icons;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Category> getCategoriesFromResponses(Response... responses) {
        log("Amount of responses: " + responses.length);

        Collection<Category> categories = new ArrayList<>();

        for(Response response : responses){
            response.getBody().jsonPath().getList("categories.items")
                    .forEach(obj -> categories.add(new Category((HashMap<String, Object>) obj)));
        }

        return categories;
    }

    public static void printAllCategoriesIDs(Collection<Category> categoryList){
        categoryList.forEach(category -> log("Category ID: " + category.getId()));
    }
}
