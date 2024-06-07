/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Statistics API
 * The Marketing Campaigns Stats API allows you to retrieve statistics for both Automations and Single Sends. The statistics provided include bounces, clicks, opens, and more. You can export stats in CSV format for use in other applications. You can also retrieve Marketing Campaigns stats in the [Marketing Campaigns application user interface](https://mc.sendgrid.com/).  This API provides statistics for Marketing Campaigns only. For stats related to event tracking, please see the [Stats API](https://docs.sendgrid.com/api-reference/stats).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mcstats;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiErrorResponse;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.mcstats.models.AutomationsResponse;
import com.sendgrid.rest.api.v3.mcstats.models.ErrorResponse;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAutomationsById {
    private final String id;
    private String query;


    public AutomationsResponse send(final TokenRestClient client) {
        String path = "/v3/marketing/stats/automations/{id}";
        Request.Builder builder = new Request.Builder(HttpMethod.GET, path)
                .addPathParam("id", id.toString());
        addQueryParam(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "GetAutomationsById creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "400")) {
                ErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        ErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "404")) {
                error = JsonUtil.fromJson(
                        response.getStream(),
                        . class
        );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

        }
        return JsonUtil.fromJson(response.getStream(), AutomationsResponse.class);
    }


    private void addQueryParams(Request.Builder builder) {
        builder.addQueryParams("query", query.toString());

    }


}
