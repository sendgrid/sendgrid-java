/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Contacts API
 * The Twilio SendGrid Marketing Campaigns Contacts API allows you to manage all of your marketing contacts programmatically. You can also import and export contacts using this API. The Contacts API allows you to associate contacts with lists and segments; however, to manage the lists and segments themselves, see the [Lists API](https://docs.sendgrid.com/api-reference/lists/) and [Segments API](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2/).  You can also manage your marketing contacts with the [Marketing Campaigns application user interface](https://mc.sendgrid.com/contacts). See [**How to Send Email with New Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/how-to-send-email-with-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mccontacts;

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
import com.sendgrid.rest.api.v3.mccontacts.models.ErrorResponse;
import com.sendgrid.rest.api.v3.mccontacts.models.ListContact200Response;
import com.sendgrid.rest.api.v3.mccontacts.models.ListContact400Response;
import com.sendgrid.rest.api.v3.mccontacts.models.SearchContact500Response;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ListContact extends ApiKeyBase {

    public ApiResponse<ListContact200Response> send(
        final ApiKeyRestClient client
    ) {
        String path = "/v3/marketing/contacts";
        Request request = new Request(
            HttpMethod.GET,
            path,
            Domains.API.toString()
        );
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "ListContact creation failed: Unable to connect to server"
            );
        } else if (
            !ApplicationConstants.SUCCESS.test(response.getStatusCode())
        ) {
            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "400")) {
                ListContact400Response error = JsonUtil.fromJson(
                    response.getStream(),
                    ListContact400Response.class
                );
                throw new ApiErrorResponse(
                    statusCode,
                    null,
                    error,
                    response.getHeaders()
                );
            }

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

            if (Matcher.matches(Integer.toString(statusCode), "500")) {
                SearchContact500Response error = JsonUtil.fromJson(
                    response.getStream(),
                    SearchContact500Response.class
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
                ListContact200Response.class
            ),
            response.getHeaders()
        );
    }
}
