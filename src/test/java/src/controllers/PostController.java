package src.controllers;

import io.restassured.response.Response;

import java.util.Map;

public class PostController extends DefaultController {
    public static Response addPost(boolean data, Map<String, String> headers, String body) {
        return DefaultController.givenDataSetup(data, headers, body).request("POST", "https://jsonplaceholder.typicode.com/posts");
    }
}
