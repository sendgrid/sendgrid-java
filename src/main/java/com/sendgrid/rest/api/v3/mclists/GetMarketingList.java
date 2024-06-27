/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Lists API
 * The Twilio SendGrid Marketing Campaigns Lists API allows you to manage your contacts lists programmatically. Lists are static collections of Marketing Campaigns contacts. You can use this API to interact with the list objects themselves. To add contacts to a list, you must use the [Contacts API](https://docs.sendgrid.com/api-reference/contacts/).  You can also manage your lists using the Contacts menu in the [Marketing Campaigns application user interface](https://mc.sendgrid.com/contacts). For more information about lists and best practices for building them, see [**Building your Contact Lists**](https://sendgrid.com/docs/ui/managing-contacts/building-your-contact-list/).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mclists;

import com.fasterxml.jackson.core.type.TypeReference;
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
import com.sendgrid.rest.api.v3.mclists.models.Error;
import com.sendgrid.rest.api.v3.mclists.models.GetMarketingList200Response;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class GetMarketingList extends ApiKeyBase {

    private final String id;

    @Setter
    private Boolean contactSample;

    public ApiResponse<GetMarketingList200Response> send(
        final ApiKeyRestClient client
    ) {
        String path = "/v3/marketing/lists/{id}";
        Request request = new Request(
            HttpMethod.GET,
            path,
            Domains.API.toString()
        );
        addPathParams(request);
        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "GetMarketingList creation failed: Unable to connect to server"
            );
        } else if (
            !ApplicationConstants.SUCCESS.test(response.getStatusCode())
        ) {
            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "404")) {
                TypeReference listTypeReference = new TypeReference<
                    List<Error>
                >() {};
                List<Error> error = (List<Error>) JsonUtil.fromJson(
                    response.getStream(),
                    listTypeReference
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
                GetMarketingList200Response.class
            ),
            response.getHeaders()
        );
    }

    private void addPathParams(Request request) {
        if (id != null) {
            request.addPathParam("id", id.toString());
        }
    }

    private void addQueryParams(Request request) {
        if (contactSample != null) {
            request.addQueryParam("contact_sample", contactSample.toString());
        }
    }
}