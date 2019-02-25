package main.test.runners;

import com.jayway.restassured.response.Response;
import main.test.spotify.model.Category;
import main.test.steps.CategorySteps;
import main.test.utils.StringParser;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Map;

import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class SpotifyCategoryTests extends SpotifyBaseTests {
    CategorySteps categorySteps = new CategorySteps();
    Category category = new Category();

    @Test
    public void getCategories(){
        Response response = categorySteps.getBrowseCategories(CURRENT_TOKEN);
        assertEquals(response.getStatusCode(), SC_OK, "Expected OK response code not returned");

        String next = response.getBody().jsonPath().get("categories.next");

        logger.log("NEXT: " + next);
        Map<String, String> params = StringParser.extractParametersFromURL(next);
        params.forEach((key, value) -> logger.log("key: " + key + ", value: " + value));

        Response response2 = categorySteps.getBrowseCategories(CURRENT_TOKEN, params);

        Collection<Category> allCategories = category.getCategoriesFromResponses(response, response2);

        category.printAllCategoriesIDs(allCategories);
    }
}
