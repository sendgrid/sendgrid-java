package com.sendgrid.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RestClient {
    public static final Predicate<Integer> SUCCESS = i -> i != null && i >= 200 && i < 400;
    @Getter
    private final HttpClient httpClient;
    @Getter
    private final List<String> userAgentExtensions;

    protected RestClient(final Builder b) {
        this.httpClient = b.httpClient;
        this.userAgentExtensions = b.userAgentExtensions;
    }

    public static class Builder<T extends Builder<T>> {
        private HttpClient httpClient;
        private List<String> userAgentExtensions;
        
        // Method to return the correct Builder type
        protected T self() {
            return (T) this;
        }
        public Builder httpClient(final HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public Builder userAgentExtensions(final List<String> userAgentExtensions) {
            if (userAgentExtensions != null && !userAgentExtensions.isEmpty()) {
                this.userAgentExtensions = new ArrayList<>(userAgentExtensions);
            }
            return this;
        }
        
        public RestClient build() {
            return new RestClient(this);
        }
    }
    
}
