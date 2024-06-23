package com.sendgrid.exception;


import lombok.Getter;
import org.apache.http.Header;


public class ApiErrorResponse extends RuntimeException {
    @Getter
    private Integer statusCode;
    @Getter
    private String statusMessage;
    @Getter
    private Object error;
    @Getter
    private Header[] headers;
    
    public ApiErrorResponse(Integer statusCode, String statusMessage, Object error, Header[] headers) {
        super("An error has occurred");
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.error = error;
        this.headers = headers;
    }
    public ApiErrorResponse() {
        super();
    }
}
