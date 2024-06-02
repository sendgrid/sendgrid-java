package com.sendgrid.exception;

import com.sun.net.httpserver.Headers;
import lombok.Getter;

import java.util.Map;

public class ApiErrorResponse extends RuntimeException {
    @Getter
    private Integer statusCode;
    @Getter
    private String statusMessage;
    @Getter
    private Object error;
    @Getter
    private Headers[] headers;
    
    public ApiErrorResponse(Integer statusCode, String statusMessage, Object error, Headers[] headers) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.error = error;
        this.headers = headers;
    }
    public ApiErrorResponse() {
        super();
    }
}
