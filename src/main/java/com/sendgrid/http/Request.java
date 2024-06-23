package com.sendgrid.http;

import com.sendgrid.util.Utility;
import lombok.Getter;
import lombok.Setter;

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
    private String body;
    @Getter
    private Map<String, String> headers;
    @Getter
    @Setter
    private String region;
    @Getter
    @Setter
    private List<String> userAgentExtensions;
    
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

        public Builder addHeaderParam(String key, String value) {
            headers.put(key, value);
            return this;
        }

        /*
         *  Sendgrid follows Resource Query Language(RQL) for Query parameters instead of following standard query parameters.
         *  limit:  If limit occurs as query param in open api spec
         *  offset: If offset occurs as query param in open api spec
         *  query:  If there is query parameter apart from limit and offset.
         *  It will be the responsibility of the client to build a compound query, encode it and pass it as a query parameter in the query field.
         */
        public Builder addQueryParam(String key, String value) {
            if (!queryParams.containsKey(key)) {
                queryParams.put(key, new ArrayList<String>());
            }
            queryParams.get(key).add(value);
            return this;
        }

        public Builder addBody(String body) {
            this.body = body;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}
