/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Legacy Marketing Campaigns Campaigns API
 * The Twilio SendGrid Legacy Marketing Campaigns Campaigns API allows you to manage your marketing email messages programmatically. This API is operational, but we recommend using the current version of Marketing Campaigns to manage your marketing messages with SendGrid [Single Sends](https://docs.sendgrid.com/api-reference/single-sends/) and [Automations](https://docs.sendgrid.com/ui/sending-email/getting-started-with-automation).  See [**Migrating from Legacy Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/migrating-from-legacy-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.lmccampaigns;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiErrorResponse;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.lmccampaigns.models.ErrorResponse;
import com.sendgrid.rest.api.v3.lmccampaigns.models.ViewScheduledTimeOfACampaignResponse;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetSchedules {
    private final Integer campaignId;
    private String onBehalfOf;


    public ViewScheduledTimeOfACampaignResponse send(final TokenRestClient client) {
        String path = "/v3/campaigns/{campaign_id}/schedules";
        Request.Builder builder = new Request.Builder(HttpMethod.GET, path)
                .addPathParam("campaign_id", campaignId.toString());
        addHeaderParams(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "GetSchedules creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "404")) {
                ErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        ErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

        }
        return JsonUtil.fromJson(response.getStream(), ViewScheduledTimeOfACampaignResponse.class);
    }


    private void addHeaderParams(Request.Builder builder) {
        if (onBehalfOf != null) {
            builder.addHeaderParams("on-behalf-of", onBehalfOf.toString());
        }

    }


}
