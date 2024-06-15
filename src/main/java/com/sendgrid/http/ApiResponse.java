package com.sendgrid.http;

import lombok.Getter;

import java.util.Map;
import java.util.StringJoiner;

public class ApiResponse<T> {
    @Getter
    private Integer statusCode;
    @Getter
    private String statusMessage;
    @Getter
    private T body;
    @Getter
    private Map<String, String> headers;


    public ApiResponse(int statusCode, String statusMessage, Map<String, String> headers) {
        this.body = null;
        this.headers = headers;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public ApiResponse(int statusCode, String statusMessage, T body, Map<String, String> headers) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.body = body;
        this.headers = headers;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", ApiResponse.class.getSimpleName() + "(", ")");
        if (statusCode != null) joiner.add("statusCode=" + statusCode);
        if (statusMessage != null) joiner.add("statusMessage=" + statusMessage);
        if (statusMessage != null) joiner.add("body=" + body);
        if (statusMessage != null) joiner.add("headers=" + headers);
        return joiner.toString();
    }
}
