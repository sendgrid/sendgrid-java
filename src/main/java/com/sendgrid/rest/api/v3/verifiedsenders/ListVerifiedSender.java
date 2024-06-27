/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Verified Senders API
 * The Twilio SendGrid Verified Senders API allows you to programmatically manage the Sender Identities that are authorized to send email for your account. You can also manage Sender Identities in the [SendGrid application user interface](https://app.sendgrid.com/settings/sender_auth). See [**Single Sender Verification**](https://sendgrid.com/docs/ui/sending-email/sender-verification/) for more information.  You an use this API to create new Sender Identities, retrieve a list of existing Sender Identities, check the status of a Sender Identity, update a Sender Identity, and delete a Sender Identity.  This API offers additional operations to check for domains known to implement DMARC and resend verification emails to Sender Identities that have yet to complete the verification process.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.verifiedsenders;

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
import com.sendgrid.rest.api.v3.verifiedsenders.models.ErrorResponse;
import com.sendgrid.rest.api.v3.verifiedsenders.models.ListVerifiedSender200Response;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ListVerifiedSender extends ApiKeyBase {

    @Setter
    private BigDecimal limit;

    @Setter
    private BigDecimal lastSeenID;

    @Setter
    private Integer id;

    public ApiResponse<ListVerifiedSender200Response> send(
        final ApiKeyRestClient client
    ) {
        String path = "/v3/verified_senders";
        Request request = new Request(
            HttpMethod.GET,
            path,
            Domains.API.toString()
        );
        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "ListVerifiedSender creation failed: Unable to connect to server"
            );
        } else if (
            !ApplicationConstants.SUCCESS.test(response.getStatusCode())
        ) {
            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "401")) {
                ErrorResponse error = JsonUtil.fromJson(
                    response.getStream(),
                    ErrorResponse.class
                );
                throw new ApiErrorResponse(
                    statusCode,
                    null,
                    error,
                    response.getHeaders()
                );
            }

            if (Matcher.matches(Integer.toString(statusCode), "403")) {
                ErrorResponse error = JsonUtil.fromJson(
                    response.getStream(),
                    ErrorResponse.class
                );
                throw new ApiErrorResponse(
                    statusCode,
                    null,
                    error,
                    response.getHeaders()
                );
            }

            if (Matcher.matches(Integer.toString(statusCode), "404")) {
                ErrorResponse error = JsonUtil.fromJson(
                    response.getStream(),
                    ErrorResponse.class
                );
                throw new ApiErrorResponse(
                    statusCode,
                    null,
                    error,
                    response.getHeaders()
                );
            }

            if (Matcher.matches(Integer.toString(statusCode), "500")) {
                Object error = JsonUtil.fromJson(
                    response.getStream(),
                    Object.class
                );
                throw new ApiErrorResponse(
                    statusCode,
                    null,
                    error,
                    response.getHeaders()
                );
            }

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
                ListVerifiedSender200Response.class
            ),
            response.getHeaders()
        );
    }

    private void addQueryParams(Request request) {
        if (limit != null) {
            request.addQueryParam("limit", limit.toString());
        }
        if (lastSeenID != null) {
            request.addQueryParam("lastSeenID", lastSeenID.toString());
        }
        if (id != null) {
            request.addQueryParam("id", id.toString());
        }
    }
}
