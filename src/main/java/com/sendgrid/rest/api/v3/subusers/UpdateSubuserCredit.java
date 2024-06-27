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
import com.sendgrid.rest.api.v3.subusers.models.ErrorResponse;
import com.sendgrid.rest.api.v3.subusers.models.SubuserCredits;
import com.sendgrid.rest.api.v3.subusers.models.SubuserCreditsRequest;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class UpdateSubuserCredit extends ApiKeyBase {

    private final String subuserName;

    @Setter
    private SubuserCreditsRequest subuserCreditsRequest;

    public ApiResponse<SubuserCredits> send(final ApiKeyRestClient client) {
        String path = "/v3/subusers/{subuser_name}/credits";
        Request request = new Request(
            HttpMethod.PUT,
            path,
            Domains.API.toString()
        );
        addPathParams(request);
        addBody(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                "UpdateSubuserCredit creation failed: Unable to connect to server"
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
            JsonUtil.fromJson(response.getStream(), SubuserCredits.class),
            response.getHeaders()
        );
    }

    private void addPathParams(Request request) {
        if (subuserName != null) {
            request.addPathParam("subuser_name", subuserName.toString());
        }
    }

    private void addBody(final Request request) {
        if (subuserCreditsRequest != null) {
            request.addBody(JsonUtil.toJson(subuserCreditsRequest));
        }
    }
}
