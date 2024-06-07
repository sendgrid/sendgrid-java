/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Account Provisioning API
 * The Twilio SendGrid Account Provisioning API provides a platform for Twilio SendGrid resellers to manage their customer accounts. This API is for companies that have a formal reseller partnership with Twilio SendGrid.  You can access Twilio SendGrid sub-account functionality without becoming a reseller. If you require sub-account functionality, see the Twilio [SendGrid Subusers](https://docs.sendgrid.com/ui/account-and-settings/subusers) feature, which is available with [Pro and Premier plans](https://sendgrid.com/pricing/).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.accountprovisioning;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.accountprovisioning.models.AccountList;
import com.sendgrid.util.JsonUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAccount {
    private String offset;
    private Integer limit;


    public AccountList send(final TokenRestClient client) {
        String path = "/v3/partners/accounts";
        Request.Builder builder = new Request.Builder(HttpMethod.GET, path);
        addQueryParam(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "GetAccount creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
        }
        return JsonUtil.fromJson(response.getStream(), AccountList.class);
    }


    private void addQueryParams(Request.Builder builder) {
        builder.addQueryParams("offset", offset.toString());
        builder.addQueryParams("limit", limit.toString());

    }


}
