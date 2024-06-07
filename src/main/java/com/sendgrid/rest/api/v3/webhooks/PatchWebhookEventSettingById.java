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

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiErrorResponse;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.webhooks.models.EventWebhookRequest;
import com.sendgrid.rest.api.v3.webhooks.models.EventWebhookUnsignedResponse;
import com.sendgrid.rest.api.v3.webhooks.models.PostUserWebhooksEventSettings400Response;
import com.sendgrid.rest.api.v3.webhooks.models.PostUserWebhooksEventSettings400ResponseAnyOf;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PatchWebhookEventSettingById {
    private final String id;
    private String query;
    private String onBehalfOf;
    private final EventWebhookRequest eventWebhookRequest;


    public EventWebhookUnsignedResponse send(final TokenRestClient client) {
        String path = "/v3/user/webhooks/event/settings/{id}";
        Request.Builder builder = new Request.Builder(HttpMethod.PATCH, path)
                .addPathParam("id", id.toString());
        addQueryParam(builder);
        addHeaderParams(builder);
        body(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "PatchWebhookEventSettingById creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "400")) {
                PostUserWebhooksEventSettings400Response error = JsonUtil.fromJson(
                        response.getStream(),
                        PostUserWebhooksEventSettings400Response.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "404")) {
                PostUserWebhooksEventSettings400ResponseAnyOf error = JsonUtil.fromJson(
                        response.getStream(),
                        PostUserWebhooksEventSettings400ResponseAnyOf.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

        }
        return JsonUtil.fromJson(response.getStream(), EventWebhookUnsignedResponse.class);
    }


    private void addHeaderParams(Request.Builder builder) {
        if (onBehalfOf != null) {
            builder.addHeaderParams("on-behalf-of", onBehalfOf.toString());
        }

    }


    private void addQueryParams(Request.Builder builder) {
        builder.addQueryParams("query", query.toString());

    }


    private void body(final Request.Builder builder) {
        if (eventWebhookRequest != null) {
            builder.body(JsonUtil.toJson(eventWebhookRequest));
        }
    }

}
