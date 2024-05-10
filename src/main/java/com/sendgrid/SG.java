package com.sendgrid;

import com.sendgrid.exception.AuthenticationException;
import com.sendgrid.http.RestClient;
import com.sendgrid.http.TokenRestClient;

import java.util.Objects;

public class SG {
    private static String apiKey = System.getenv("API_KEY");
    private static volatile TokenRestClient tokenRestClient;
    
    private SG() {
    }

    public static synchronized void init(final String apiKey) {
        if (apiKey == null) {
            throw new AuthenticationException("Username can not be null");
        }
        SG.apiKey = apiKey;
    }


    // Explore Data Residency
    public static synchronized void setRegion(final String region) {
        
    }

    public static RestClient getTokenRestClient() {
        if (SG.tokenRestClient == null) {
            synchronized (SG.class) {
                if (SG.tokenRestClient == null) {
                    SG.tokenRestClient = buildTokenRestClient();
                }
            }
        }

        return SG.tokenRestClient;
    }

    private static TokenRestClient buildTokenRestClient() {
        if (SG.apiKey == null) {
            throw new AuthenticationException(
                    "TwilioRestClient was used before AccountSid and AuthToken were set, please call Twilio.init()"
            );
        }

        return null;
    }
}
