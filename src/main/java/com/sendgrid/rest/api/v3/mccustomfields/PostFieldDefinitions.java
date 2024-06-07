/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Custom Fields API
 * The Twilio SendGrid Marketing Campaigns Custom Fields API allows you to add extra information about your marketing contacts that is relevant to your needs. For example, a fashion retailer might create a custom field for customers' shoe sizes, an ice cream shop might store customers' favorite flavors in a custom field, and you can create custom fields that make sense for your business.  With custom fields, you can also create [segments](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2/) based on custom fields values. Your custom fields are completely customizable to the use-cases and user information that you need.  You can also manage your Custom Fields using the SendGrid application user interface. See [**Using Custom Fields**](https://docs.sendgrid.com/ui/managing-contacts/custom-fields) for more information, including a list of Reserved Fields. You can also manage your custom fields in the [Marketing Campaigns application user interface](https://mc.sendgrid.com/custom-fields).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mccustomfields;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiErrorResponse;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.mccustomfields.models.PostMarketingFieldDefinitions200Response;
import com.sendgrid.rest.api.v3.mccustomfields.models.PostMarketingFieldDefinitions400Response;
import com.sendgrid.rest.api.v3.mccustomfields.models.PostMarketingFieldDefinitionsRequest;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostFieldDefinitions {
    private final PostMarketingFieldDefinitionsRequest postMarketingFieldDefinitionsRequest;


    public PostMarketingFieldDefinitions200Response send(final TokenRestClient client) {
        String path = "/v3/marketing/field_definitions";
        Request.Builder builder = new Request.Builder(HttpMethod.POST, path);
        body(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "PostFieldDefinitions creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "400")) {
                PostMarketingFieldDefinitions400Response error = JsonUtil.fromJson(
                        response.getStream(),
                        PostMarketingFieldDefinitions400Response.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

        }
        return JsonUtil.fromJson(response.getStream(), PostMarketingFieldDefinitions200Response.class);
    }


    private void body(final Request.Builder builder) {
        if (postMarketingFieldDefinitionsRequest != null) {
            builder.body(JsonUtil.toJson(postMarketingFieldDefinitionsRequest));
        }
    }

}
