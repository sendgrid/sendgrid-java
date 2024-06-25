package com.sendgrid;

import com.sendgrid.constant.EnumConstants;
import com.sendgrid.constant.ErrorMessages;
import com.sendgrid.exception.AuthenticationException;
import com.sendgrid.http.ApiKeyRestClient;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ApiKeySendGrid {
    private static String apiKey = System.getenv("SENDGRID_API_KEY");
    private static String region = System.getenv("SENDGRID_REGION");
    @Getter
    private static List<String> userAgentExtensions;
    private static volatile ApiKeyRestClient apiKeyRestClient;
    
    private ApiKeySendGrid() {
    }

    public static synchronized void init(final String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new AuthenticationException(String.format(ErrorMessages.EMPTY_STRING, "API_KEY"));
        }
        ApiKeySendGrid.apiKey = apiKey;
    }


    // Explore Data Residency
    /**
     * Set the region.
     *
     * @param region region to make request
     * Global Region api.sendgrid.com
     * EU Region api.eu.sendgrid.com
     */
    public static synchronized void setRegion(final String region) {
        if (region == null || region.isEmpty()) {
            throw new AuthenticationException(String.format(ErrorMessages.EMPTY_STRING, "REGION"));
        }
        if (!EnumConstants.Region.getValues().contains(region)) {
            throw new AuthenticationException(String.format(ErrorMessages.INVALID_STRING, "REGION"));
        }
        if (!Objects.equals(region, ApiKeySendGrid.region)) {
            ApiKeySendGrid.invalidate();
        }
        ApiKeySendGrid.region = region;
    }

    public static synchronized void setUserAgentExtensions(final List<String> userAgentExtensions) {
        if (userAgentExtensions != null && !userAgentExtensions.isEmpty()) {
            ApiKeySendGrid.userAgentExtensions = new ArrayList<>(userAgentExtensions);
        } else {
            // In case a developer wants to reset userAgentExtensions
            ApiKeySendGrid.userAgentExtensions = null;
        }
    }
    

    public static ApiKeyRestClient getRestClient() {
        if (ApiKeySendGrid.apiKeyRestClient == null) {
            synchronized (ApiKeySendGrid.class) {
                if (ApiKeySendGrid.apiKeyRestClient == null) {
                    ApiKeySendGrid.apiKeyRestClient = buildRestClient();
                }
            }
        }

        return ApiKeySendGrid.apiKeyRestClient;
    }

    private static ApiKeyRestClient buildRestClient() {
        if (ApiKeySendGrid.apiKey == null) {
            throw new AuthenticationException(
                    "Api Key is not initialized, please call ApiKeySendGrid.init()"
            );
        }
        ApiKeyRestClient.Builder builder = new ApiKeyRestClient.Builder(ApiKeySendGrid.apiKey);
        if (userAgentExtensions != null) {
            builder.userAgentExtensions(ApiKeySendGrid.userAgentExtensions);
        }
        if (region == null)
            builder.region(EnumConstants.Region.GLOBAL.getValue());
        else 
            builder.region(region);
        return builder.build();
    }

    /**
     * Invalidates the volatile state held in the Sendgrid singleton.
     */
    private static void invalidate() {
        ApiKeySendGrid.apiKeyRestClient = null;
    }
}
