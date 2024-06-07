/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid IP Address Management API
 * The Twilio SendGrid IP Address Management API combines functionality that was previously split between the Twilio SendGrid [IP Address API](https://docs.sendgrid.com/api-reference/ip-address) and [IP Pools API](https://docs.sendgrid.com/api-reference/ip-pools). This functionality includes adding IP addresses to your account, assigning IP addresses to IP Pools and Subusers, among other tasks.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.ipaddressmanagement;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiErrorResponse;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.ipaddressmanagement.models.IpAddressManagementErrorResponse;
import com.sendgrid.rest.api.v3.ipaddressmanagement.models.PostSendIpsIpsIpSubusersBatchAddRequest;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostIpSubuserBatchDelete {
    private final String ip;
    private final PostSendIpsIpsIpSubusersBatchAddRequest postSendIpsIpsIpSubusersBatchAddRequest;


    public void send(final TokenRestClient client) {
        String path = "/v3/send_ips/ips/{ip}/subusers:batchDelete";
        Request.Builder builder = new Request.Builder(HttpMethod.POST, path)
                .addPathParam("ip", ip.toString());
        body(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "PostIpSubuserBatchDelete creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "400")) {
                IpAddressManagementErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        IpAddressManagementErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "401")) {
                IpAddressManagementErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        IpAddressManagementErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "500")) {
                IpAddressManagementErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        IpAddressManagementErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

        }
        return;
    }


    private void body(final Request.Builder builder) {
        if (postSendIpsIpsIpSubusersBatchAddRequest != null) {
            builder.body(JsonUtil.toJson(postSendIpsIpsIpSubusersBatchAddRequest));
        }
    }

}
