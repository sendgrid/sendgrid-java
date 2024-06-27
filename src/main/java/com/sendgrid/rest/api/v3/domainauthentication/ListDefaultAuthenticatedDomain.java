/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Domain Authentication API
 * The Twilio SendGrid Domain Authentication API allows you to manage your authenticated domains and their settings.  Domain Authentication is a required step when setting up your Twilio SendGrid account because it's essential to ensuring the deliverability of your email. Domain Authentication signals trustworthiness to email inbox providers and your recipients by approving SendGrid to send email on behalf of your domain. For more information, see [**How to Set Up Domain Authentication**](https://sendgrid.com/docs/ui/account-and-settings/how-to-set-up-domain-authentication/).  Each user may have a maximum of 3,000 authenticated domains and 3,000 link brandings. This limit is at the user level, meaning each Subuser belonging to a parent account may have its own 3,000 authenticated domains and 3,000 link brandings.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.domainauthentication;

import com.sendgrid.base.apikey.ApiKeyBase;
import com.sendgrid.constant.ApplicationConstants;
import com.sendgrid.constant.Domains;
import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiErrorResponse;
import com.sendgrid.exception.GenericApiError;
import com.sendgrid.http.ApiKeyRestClient;
import com.sendgrid.http.ApiResponse;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.util.JsonUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ListDefaultAuthenticatedDomain extends ApiKeyBase {

    @Setter
    private String domain;

    @Setter
    private String onBehalfOf;

    public ApiResponse<List<Object>> send(final ApiKeyRestClient client) {
        String path = "/v3/whitelabel/domains/default";
        Request request = new Request(
            HttpMethod.GET,
            path,
            Domains.API.toString()
        );
        addQueryParams(request);
        addHeaderParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "ListDefaultAuthenticatedDomain creation failed: Unable to connect to server"
            );
        } else if (
            !ApplicationConstants.SUCCESS.test(response.getStatusCode())
        ) {
            int statusCode = response.getStatusCode();
            GenericApiError error = JsonUtil.fromJson(
                response.getStream(),
                GenericApiError.class
            );
            throw new ApiErrorResponse(
                statusCode,
                null,
                error,
                response.getHeaders()
            );
        }
        int statusCode = response.getStatusCode();
        return new ApiResponse(
            statusCode,
            JsonUtil.fromJson(response.getStream(), List.class),
            response.getHeaders()
        );
    }

    private void addHeaderParams(Request request) {
        if (onBehalfOf != null) {
            request.addHeaderParam("on-behalf-of", onBehalfOf.toString());
        }
    }

    private void addQueryParams(Request request) {
        if (domain != null) {
            request.addQueryParam("domain", domain.toString());
        }
    }
}