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

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.stats.models.GetGeoStats200ResponseInner;
import com.sendgrid.util.JsonUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetGeoStat {
    private Integer limit;
    private Integer offset;
    private String query;
    private String onBehalfOf;


    public List<GetGeoStats200ResponseInner> send(final TokenRestClient client) {
        String path = "/v3/geo/stats";
        Request.Builder builder = new Request.Builder(HttpMethod.GET, path);
        addQueryParam(builder);
        addHeaderParams(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "GetGeoStat creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
        }
        return JsonUtil.fromJson(response.getStream(), List & lt; GetGeoStats200ResponseInner & gt;.class);
    }


    private void addHeaderParams(Request.Builder builder) {
        if (onBehalfOf != null) {
            builder.addHeaderParams("on-behalf-of", onBehalfOf.toString());
        }

    }


    private void addQueryParams(Request.Builder builder) {
        builder.addQueryParams("limit", limit.toString());
        builder.addQueryParams("offset", offset.toString());
        builder.addQueryParams("query", query.toString());

    }


}
