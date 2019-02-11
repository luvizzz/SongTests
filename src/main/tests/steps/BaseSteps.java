package main.tests.steps;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class BaseSteps {

    public BaseSteps(){ }

    public Response getSite(String url){
        return RestAssured.given()
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }
}