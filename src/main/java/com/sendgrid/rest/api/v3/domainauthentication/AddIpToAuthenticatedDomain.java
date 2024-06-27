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
import com.sendgrid.rest.api.v3.domainauthentication.models.AddIpToAuthenticatedDomainRequest;
import com.sendgrid.rest.api.v3.domainauthentication.models.AuthenticatedDomainSpf;
import com.sendgrid.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class AddIpToAuthenticatedDomain extends ApiKeyBase {

    private final Integer id;

    @Setter
    private String onBehalfOf;

    @Setter
    private AddIpToAuthenticatedDomainRequest addIpToAuthenticatedDomainRequest;

    public ApiResponse<AuthenticatedDomainSpf> send(
        final ApiKeyRestClient client
    ) {
        String path = "/v3/whitelabel/domains/{id}/ips";
        Request request = new Request(
            HttpMethod.POST,
            path,
            Domains.API.toString()
        );
        addPathParams(request);
        addHeaderParams(request);
        addBody(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "AddIpToAuthenticatedDomain creation failed: Unable to connect to server"
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
            JsonUtil.fromJson(
                response.getStream(),
                AuthenticatedDomainSpf.class
            ),
            response.getHeaders()
        );
    }

    private void addPathParams(Request request) {
        if (id != null) {
            request.addPathParam("id", id.toString());
        }
    }

    private void addHeaderParams(Request request) {
        if (onBehalfOf != null) {
            request.addHeaderParam("on-behalf-of", onBehalfOf.toString());
        }
    }

    private void addBody(final Request request) {
        if (addIpToAuthenticatedDomainRequest != null) {
            request.addBody(JsonUtil.toJson(addIpToAuthenticatedDomainRequest));
        }
    }
}
