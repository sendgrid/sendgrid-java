package com.sendgrid.http;

import com.sendgrid.http.httpclient.HttpClient;
import com.sendgrid.http.httpclient.ApiKeyHttpClient;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RestClient {
    public static final Predicate<Integer> SUCCESS = i -> i != null && i >= 200 && i < 400;
    @Getter
    final HttpClient httpClient;
    @Getter
    private final List<String> userAgentExtensions;

//    @Getter
//    private final String region;

    //static final Logger logger = LoggerFactory.getLogger(RestClient.class);

    protected RestClient(final Builder b) {
        this.httpClient = b.httpClient;
        this.userAgentExtensions = b.userAgentExtensions;
    }

    public static class Builder {
        private HttpClient httpClient;
        private List<String> userAgentExtensions;
        
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
            if (this.httpClient == null) {
                this.httpClient = new ApiKeyHttpClient();
            }
            return new RestClient(this);
        }
    }
    
}
