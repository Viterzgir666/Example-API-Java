package src.request.models;

import src.request.builders.PostBuilder;

public class PostModel {
    public int userId;
    public int id;
    public String title;
    public String body;

    public PostModel(PostBuilder builder) {
        this.userId = builder.userId;
        this.id = builder.id;
        this.title = builder.title;
        this.body = builder.body;
    }
}
