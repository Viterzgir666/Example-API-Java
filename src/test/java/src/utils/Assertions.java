package src.utils;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.response.Response;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Assertions {
    Response response;
    JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory
            .newBuilder()
            .setValidationConfiguration(
                    ValidationConfiguration
                            .newBuilder()
                            .setDefaultVersion(DRAFTV4)
                            .freeze())
            .freeze();

    public Assertions(Response res) {
        this.response = res;
    }

    public Assertions statusCodeToEqual(int code) {
        this.response
                .then()
                .assertThat()
                .statusCode(code);
        return this;
    }

    public Assertions responseBodyTypeToBe(String schema) {
        this.response
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(schema)
                        .using(jsonSchemaFactory));
        return this;
    }
}
