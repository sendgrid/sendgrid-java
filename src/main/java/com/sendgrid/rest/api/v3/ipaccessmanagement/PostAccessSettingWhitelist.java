/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid IP Access Management API
 * IP Twilio SendGrid IP Access Management API allows you to control which IP addresses can be used to access your account, either through the SendGrid application user interface or the API.  There is no limit to the number of IP addresses that you can allow.  It is possible to remove your own IP address from your list of allowed addresses, thus blocking your own access to your account. While we are able to restore your access, we do require thorough proof of your identify and ownership of your account. We take the security of your account very seriously and wish to prevent any 'bad actors' from maliciously gaining access to your account. Your current IP is clearly displayed to help prevent you from accidentally removing it from the allowed addresses.  See [**IP Access Management**](https://docs.sendgrid.com/ui/account-and-settings/ip-access-management) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.ipaccessmanagement;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiErrorResponse;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.ipaccessmanagement.models.ErrorResponse;
import com.sendgrid.rest.api.v3.ipaccessmanagement.models.IpAccessManagement2xx;
import com.sendgrid.rest.api.v3.ipaccessmanagement.models.PostAccessSettingsWhitelistRequest;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostAccessSettingWhitelist {
    private String onBehalfOf;
    private final PostAccessSettingsWhitelistRequest postAccessSettingsWhitelistRequest;


    public IpAccessManagement2xx send(final TokenRestClient client) {
        String path = "/v3/access_settings/whitelist";
        Request.Builder builder = new Request.Builder(HttpMethod.POST, path);
        addHeaderParams(builder);
        body(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "PostAccessSettingWhitelist creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "401")) {
                ErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        ErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "403")) {
                ErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        ErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "404")) {
                ErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        ErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "500")) {
                Object error = JsonUtil.fromJson(
                        response.getStream(),
                        Object.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

        }
        return JsonUtil.fromJson(response.getStream(), IpAccessManagement2xx.class);
    }


    private void addHeaderParams(Request.Builder builder) {
        if (onBehalfOf != null) {
            builder.addHeaderParams("on-behalf-of", onBehalfOf.toString());
        }

    }


    private void body(final Request.Builder builder) {
        if (postAccessSettingsWhitelistRequest != null) {
            builder.body(JsonUtil.toJson(postAccessSettingsWhitelistRequest));
        }
    }

}
