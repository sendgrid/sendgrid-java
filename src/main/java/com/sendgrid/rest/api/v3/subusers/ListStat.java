/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Subusers
 * The Twilio SendGrid Subusers API allows you to create and manage your Subuser accounts. Subusers are available on [Pro and Premier plans](https://sendgrid.com/pricing), and you can think of them as sub-accounts. Each Subuser can have its own sending domains, IP addresses, and reporting. SendGrid recommends creating Subusers for each of the different types of emails you send—one Subuser for transactional emails and another for marketing emails. Independent Software Vendor (ISV) customers may also create Subusers for each of their customers.  You can also manage Subusers in the [Twilio SendGrid application user interface](https://app.sendgrid.com/settings/subusers). See [**Subusers**](https://docs.sendgrid.com/ui/account-and-settings/subusers) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.subusers;

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
import com.sendgrid.rest.api.v3.subusers.models.AggregatedBy;
import com.sendgrid.rest.api.v3.subusers.models.CategoryStats;
import com.sendgrid.util.JsonUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class ListStat extends ApiKeyBase {

    @Setter
    private Integer limit;

    @Setter
    private Integer offset;

    @Setter
    private AggregatedBy aggregatedBy;

    private final String subusers;
    private final String startDate;

    @Setter
    private String endDate;

    public ApiResponse<List<CategoryStats>> send(
        final ApiKeyRestClient client
    ) {
        String path = "/v3/subusers/stats";
        Request request = new Request(
            HttpMethod.GET,
            path,
            Domains.API.toString()
        );
        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "ListStat creation failed: Unable to connect to server"
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
        if (subusers != null) {
            request.addQueryParam("subusers", subusers.toString());
        }
        if (startDate != null) {
            request.addQueryParam("start_date", startDate.toString());
        }
        if (endDate != null) {
            request.addQueryParam("end_date", endDate.toString());
        }
    }
}