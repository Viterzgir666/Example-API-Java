package src.request.builders;

import java.util.HashMap;
import java.util.Map;

public class HeaderBuilder {
    public Map<String, String> headers;

    public HeaderBuilder() {
        this.headers = new HashMap<>();
    }

    public HeaderBuilder addKeyValue(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public Map<String, String> build() {
        return this.headers;
    }
}
