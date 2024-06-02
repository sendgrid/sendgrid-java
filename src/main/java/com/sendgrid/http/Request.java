package com.sendgrid.http;

import com.sendgrid.util.Utility;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Request {
    @Getter
    private final HttpMethod method;
    @Getter
    private final String url;
    @Getter
    private final String body;
    @Getter
    private Map<String, String> headers;

    @Getter
    boolean requiresAuth;
    
    public void addHeader(String key, String value) {
        if (value == null || value.equals("null") || key == null) return;
        headers.put(key, value);
    }
    
    private Request(Builder builder) {
        this.method = builder.method;
        this.body = builder.body;
        this.headers = builder.headers;

        String baseUrl = builder.url;
        baseUrl = Utility.buildWithPathParams(baseUrl, builder.pathParams);
        baseUrl = Utility.buildWithQueryParams(baseUrl, builder.queryParams);
        this.url = baseUrl;
    }

    public static class Builder {
        private String url;
        private HttpMethod method;
        private Map<String, String> headers = new HashMap<>();
        private Map<String, List<String>> queryParams = new HashMap<>();
        private Map<String, String> pathParams = new HashMap<>();
        private String body;

        public Builder(HttpMethod method, String url) {
            this.method = method;
            this.url = url;
        }

        public Builder addPathParam(String key, String value) {
            this.pathParams.put(key, value);
            return this;
        }

        public Builder addHeaderParams(String key, String value) {
            if (value == null || value.equals("null") || key == null) return this;
            headers.put(key, value);
            return this;
        }

        public Builder addQueryParams(String key, String value) {
            if (value == null || value.equals("null")) return this;
            if (!queryParams.containsKey(key)) {
                queryParams.put(key, new ArrayList<String>());
            }
            queryParams.get(key).add(value);
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
