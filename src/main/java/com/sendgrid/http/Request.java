package com.sendgrid.http;

import com.sendgrid.util.Utility;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
    @Getter
    private final HttpMethod method;
    @Getter
    private final String endPoint;
    @Getter
    private final String domain;
    @Getter
    private String body;
    @Getter
    private Map<String, String> headers = new HashMap<>();
    @Getter
    private Map<String, String> queryParams = new HashMap<>();
    @Getter
    private Map<String, String> pathParams = new HashMap<>();
    @Getter
    @Setter
    private String region;
    @Getter
    @Setter
    private List<String> userAgentExtensions;

    @Getter
    private String url;
    public Request(HttpMethod method, String endPoint, String domain) {
        this.method = method;
        this.endPoint = endPoint;
        this.domain = domain;
    }
    
    public void addPathParam(String key, String value) {
        pathParams.put(key, value);
    }

    public void addHeaderParam(String key, String value) {
        headers.put(key, value);
    }

    public void addQueryParam(String key, String value) {
        queryParams.put(key, value);
    }
    
    public void addBody(String body) {
        this.body = body;
    }
    
    public void buildUrl() {
        String baseUrl = Utility.buildBaseUrl(domain, region, endPoint);
        baseUrl = Utility.buildWithPathParams(baseUrl, pathParams);
        baseUrl = Utility.buildWithQueryParams(baseUrl, queryParams);
        this.url = baseUrl;
    }

    public void buildUrl(final String url) {
        this.url = url;
    }
    
}
