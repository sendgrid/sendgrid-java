package com.sendgrid.http;

import com.sendgrid.http.Response;
import com.sendgrid.http.auth.AuthStrategy;
import com.sendgrid.http.auth.TokenStrategy;

import java.util.List;
import java.util.Map;

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
        public TokenRestClient build() {
            super.build();
            return new TokenRestClient(this);
        }
    }

    public Response request(final Request request) {
        AuthStrategy authStrategy = new TokenStrategy(token);
        authStrategy.applyAuth(request);
        logRequest(request);
        Response response = httpClient.reliableRequest(request);
        return response;
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
