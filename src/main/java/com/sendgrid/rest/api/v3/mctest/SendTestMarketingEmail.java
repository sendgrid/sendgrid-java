/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Send Test Email API
 * The Twilio SendGrid Test Email API allows you to test a marketing email by first sending it to a list of up to 10 email addresses before pushing to a contact list or segment. With this feature, you can test the layout and content of your message in multiple email clients and with multiple recipients to see how it will function in a real-world scenario.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mctest;

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
import com.sendgrid.rest.api.v3.mctest.models.ErrorResponse;
import com.sendgrid.rest.api.v3.mctest.models.SendTestMarketingEmailRequest;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class SendTestMarketingEmail extends ApiKeyBase {

    @Setter
    private SendTestMarketingEmailRequest sendTestMarketingEmailRequest;

    public ApiResponse<Object> send(final ApiKeyRestClient client) {
        String path = "/v3/marketing/test/send_email";
        Request request = new Request(
            HttpMethod.POST,
            path,
            Domains.API.toString()
        );
        addBody(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "SendTestMarketingEmail creation failed: Unable to connect to server"
            );
        } else if (
            !ApplicationConstants.SUCCESS.test(response.getStatusCode())
        ) {
            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "400")) {
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
            JsonUtil.fromJson(response.getStream(), Object.class),
            response.getHeaders()
        );
    }

    private void addBody(final Request request) {
        if (sendTestMarketingEmailRequest != null) {
            request.addBody(JsonUtil.toJson(sendTestMarketingEmailRequest));
        }
    }
}