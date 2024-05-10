package com.sendgrid.http;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Request {
    private final HttpMethod method;
    private final String url;
    private final String body;
    private final Map<String, String> headers;
    
    private Request(Builder builder) {
        this.method = builder.method;
        this.body = builder.body;
        this.headers = builder.headers;

        String baseUrl = builder.url;
        for (Map.Entry<String, String> entry : builder.pathParams.entrySet()) {
            baseUrl = baseUrl.replace("{" + entry.getKey() + "}", entry.getValue());
        }

        if (builder.queryParams.isEmpty()) {
            this.url = baseUrl;
        } else {
            StringJoiner joiner = new StringJoiner("&");
            builder.queryParams.forEach((key, value) -> {
                joiner.add(key + "=" + value);
            });
            this.url = builder.url + "?" + joiner.toString();
        }
    }

    public static class Builder {
        private String url;
        private HttpMethod method;
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();
        private Map<String, String> pathParams = new HashMap<>();
        private String body;

        public Builder(HttpMethod method, String url) {
            this.method = method;
            this.url = url;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder addQueryParams(String key, String value) {
            this.queryParams.put(key, value);
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}
