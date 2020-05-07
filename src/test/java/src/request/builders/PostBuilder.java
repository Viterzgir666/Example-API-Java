package src.request.builders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import src.request.models.PostModel;

public class PostBuilder {
    public final GsonBuilder builder = new GsonBuilder();
    public final Gson gson = builder.create();
    public int userId;
    public int id;
    public String title;
    public String body;

    public PostBuilder setUserId(int uId) {
        this.userId = uId;
        return this;
    }

    public PostBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PostBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public PostBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public String build() {
        PostModel model = new PostModel(this);
        return gson.toJson(model);
    }
}
