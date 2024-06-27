/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Statistics API
 * The Twilio SendGrid Statistics API allows you to retrieve the various statistics related to your email program.  Tracking your emails is an important part of being a good sender and learning about how your users interact with your email. This includes everything from clicks and opens to looking at which browsers and mailbox providers your customers use.  SendGrid has broken up statistics in specific ways so that you can get at-a-glance data, as well as the details of how your email is being used.  Category statistics are available for the previous thirteen months only.  See [**Statistics Overview**](https://docs.sendgrid.com/ui/analytics-and-reporting/stats-overview) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.stats;

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
import com.sendgrid.rest.api.v3.stats.models.AggregatedBy2;
import com.sendgrid.rest.api.v3.stats.models.ListClientStat200ResponseInner;
import com.sendgrid.util.JsonUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ListClientStat extends ApiKeyBase {

    private final String startDate;

    @Setter
    private String endDate;

    @Setter
    private AggregatedBy2 aggregatedBy;

    @Setter
    private String onBehalfOf;

    public ApiResponse<List<ListClientStat200ResponseInner>> send(
        final ApiKeyRestClient client
    ) {
        String path = "/v3/clients/stats";
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
                "ListClientStat creation failed: Unable to connect to server"
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
        if (startDate != null) {
            request.addQueryParam("start_date", startDate.toString());
        }
        if (endDate != null) {
            request.addQueryParam("end_date", endDate.toString());
        }
        if (aggregatedBy != null) {
            request.addQueryParam("aggregated_by", aggregatedBy.toString());
        }
    }
}