/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Webhook Configuration API
 * The Twilio SendGrid Webhooks API allows you to configure the Event and Parse Webhooks.  Email is a data-rich channel, and implementing the Event Webhook will allow you to consume those data in nearly real time. This means you can actively monitor and participate in the health of your email program throughout the send cycle.  The Inbound Parse Webhook processes all incoming email for a domain or subdomain, parses the contents and attachments and then POSTs `multipart/form-data` to a URL that you choose.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.webhooks;

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
import com.sendgrid.rest.api.v3.webhooks.models.AggregatedBy;
import com.sendgrid.rest.api.v3.webhooks.models.ListParseStatic200ResponseInner;
import com.sendgrid.util.JsonUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ListParseStatic extends ApiKeyBase {

    @Setter
    private String limit;

    @Setter
    private String offset;

    @Setter
    private AggregatedBy aggregatedBy;

    private final String startDate;

    @Setter
    private String endDate;

    @Setter
    private String onBehalfOf;

    public ApiResponse<List<ListParseStatic200ResponseInner>> send(
        final ApiKeyRestClient client
    ) {
        String path = "/v3/user/webhooks/parse/stats";
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
                "ListParseStatic creation failed: Unable to connect to server"
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
        if (limit != null) {
            request.addQueryParam("limit", limit.toString());
        }
        if (offset != null) {
            request.addQueryParam("offset", offset.toString());
        }
        if (aggregatedBy != null) {
            request.addQueryParam("aggregated_by", aggregatedBy.toString());
        }
        if (startDate != null) {
            request.addQueryParam("start_date", startDate.toString());
        }
        if (endDate != null) {
            request.addQueryParam("end_date", endDate.toString());
        }
    }
}
