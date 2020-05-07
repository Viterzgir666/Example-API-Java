package src.controllers;

import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class DefaultController {

    protected static RequestSpecification givenDataSetup(boolean data, Map<String, String> headers, String body) {
        if (!data) {
            return given();
        } else {
            return given()
                    .headers(headers)
                    .body(body);
        }

    }
}
