package com.sendgrid.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sendgrid.http.auth.AuthStrategy;
import com.sendgrid.http.auth.TokenStrategy;
import com.sendgrid.http.httpclient.HttpClient;
import com.sendgrid.http.httpclient.ApiKeyHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ApiKeyRestClient {
    private final String apiKey;
    @Getter
    private final String region;
    @Getter
    private final ObjectMapper objectMapper;
    private final AuthStrategy tokenStrategy;
    @Getter
    private final HttpClient httpClient;
    @Getter
    private final List<String> userAgentExtensions;
    private static final Logger logger = LoggerFactory.getLogger(ApiKeyRestClient.class);
    
    protected ApiKeyRestClient(Builder builder) {
        this.apiKey = builder.apiKey;
        this.region = builder.region;
        this.userAgentExtensions = builder.userAgentExtensions;
        this.objectMapper = new ObjectMapper();
        this.tokenStrategy = new TokenStrategy(apiKey);
        this.httpClient = builder.httpClient;
    }

    public Response request(final Request request) {
        tokenStrategy.applyAuth(request);
        if (region != null)
            request.setRegion(region);
        if (userAgentExtensions != null && !userAgentExtensions.isEmpty()) {
            request.setUserAgentExtensions(userAgentExtensions);
        }
        logRequest(request);

        Response response = httpClient.makeRequest(request);

        if (logger.isDebugEnabled()) {
            logger.debug("status code: {}", response.getStatusCode());
            org.apache.http.Header[] responseHeaders = response.getHeaders();
            logger.debug("response headers:");
            for (int i = 0; i < responseHeaders.length; i++) {
                logger.debug("responseHeader: {}", responseHeaders[i]);
            }
        }

        return response;
    }
    
    
    public static class Builder {
        private String apiKey;
        private String region;
        private List<String> userAgentExtensions;
        private HttpClient httpClient;
        public Builder(String apiKey) {
            this.apiKey = apiKey;
        }
        public Builder region(String region) {
            this.region = region;
            return this;
        }
        public Builder userAgentExtensions(List<String> userAgentExtensions) {
            if (userAgentExtensions != null && !userAgentExtensions.isEmpty()) {
                this.userAgentExtensions = new ArrayList<>(userAgentExtensions);
            }
            return this;
        }
        public ApiKeyRestClient build() {
            if (this.httpClient == null) {
                this.httpClient = new ApiKeyHttpClient();
            }
            return new ApiKeyRestClient(this);
        }
    }



    public void logRequest(final Request request) {
//        if (logger.isDebugEnabled()) {
//            logger.debug("-- BEGIN Twilio API Request --");
//            logger.debug("request method: " + request.getMethod());
//            // TODO: URL Encode query params before logging.
//            logger.debug("request URL: " + request.getUrl().toString());
//            
//            final Map<String, String> headerParams = request.getHeaders();
//
//            if (headerParams != null && !headerParams.isEmpty()) {
//                logger.debug("header parameters: ");
//                for (String key : headerParams.keySet()) {
//                    if (!key.toLowerCase().contains("authorization")) {
//                        logger.debug(key + ": " + headerParams.get(key));
//                    }
//                }
//            }
//
//            logger.debug("-- END Twilio API Request --");
//        }
    }
}
