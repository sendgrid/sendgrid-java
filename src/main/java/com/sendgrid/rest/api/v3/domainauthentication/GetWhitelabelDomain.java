/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Domain Authentication API
 * The Twilio SendGrid Domain Authentication API allows you to manage your authenticated domains and their settings.  Domain Authentication is a required step when setting up your Twilio SendGrid account because it's essential to ensuring the deliverability of your email. Domain Authentication signals trustworthiness to email inbox providers and your recipients by approving SendGrid to send email on behalf of your domain. For more information, see [**How to Set Up Domain Authentication**](https://sendgrid.com/docs/ui/account-and-settings/how-to-set-up-domain-authentication/).  Each user may have a maximum of 3,000 authenticated domains and 3,000 link brandings. This limit is at the user level, meaning each Subuser belonging to a parent account may have its own 3,000 authenticated domains and 3,000 link brandings.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.domainauthentication;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.domainauthentication.models.AuthenticatedDomain;
import com.sendgrid.util.JsonUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetWhitelabelDomain {
    private Integer limit;
    private Integer offset;
    private String query;
    private String onBehalfOf;


    public List<AuthenticatedDomain> send(final TokenRestClient client) {
        String path = "/v3/whitelabel/domains";
        Request.Builder builder = new Request.Builder(HttpMethod.GET, path);
        addQueryParam(builder);
        addHeaderParams(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "GetWhitelabelDomain creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
        }
        return JsonUtil.fromJson(response.getStream(), List & lt; AuthenticatedDomain & gt;.class);
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
