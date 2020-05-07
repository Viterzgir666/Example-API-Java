package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import src.controllers.PostController;
import src.generics.Generate;
import src.request.builders.HeaderBuilder;
import src.request.builders.PostBuilder;
import src.utils.Assertions;

import java.util.Map;

public class PostTest {

    @Test
    public void userIsAbleToAddANewPost() {
        int id = Generate.id();
        int userId = Generate.id();
        String title = Generate.title();
        String body = Generate.body();

        String postBody = new PostBuilder()
                .setId(id)
                .setUserId(userId)
                .setTitle(title)
                .setBody(body)
                .build();
        Map<String, String> headers = new HeaderBuilder()
                .addKeyValue("Content-Type", "application/json")
                .build();

        Response resp = PostController.
                addPost(true, headers, postBody);
        Assertions assertion = new Assertions(resp);
        assertion
                .statusCodeToEqual(201)
                .responseBodyTypeToBe("posts.json");
    }
}
