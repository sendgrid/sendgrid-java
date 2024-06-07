/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid IP Address API
 * The Twilio SendGrid IP Address API allows you to add and manage dedicated IP addresses and IP Pools for your SendGrid account and Subusers. If you are sending any significant amount of email, SendGrid typically suggests sending from dedicated IPs. It's also best to send marketing and transactional emails from separate IP addresses. In order to do this, you'll need to set up IP Pools, which are groups of dedicated IP addresses you define to send particular types of messages. See the [**Dedicated IP Addresses**](https://docs.sendgrid.com/ui/account-and-settings/dedicated-ip-addresses) for more information about obtaining and allocating IPs.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.ips;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.ips.models.GetIpsRemaining200Response;
import com.sendgrid.util.JsonUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetIpRemaining {


    public GetIpsRemaining200Response send(final TokenRestClient client) {
        String path = "/v3/ips/remaining";
        Request.Builder builder = new Request.Builder(HttpMethod.GET, path);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "GetIpRemaining creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
        }
        return JsonUtil.fromJson(response.getStream(), GetIpsRemaining200Response.class);
    }


}
