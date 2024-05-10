package com.sendgrid.http;

public class TokenRestClient extends RestClient {
    private final String token;
    
    protected TokenRestClient(Builder builder) {
        super(builder);
        this.token = builder.token;
    }
    
    public static class Builder extends RestClient.Builder<Builder> {
        private String token;
        public Builder(String token) {
            this.token = token;
        }
    }
}
