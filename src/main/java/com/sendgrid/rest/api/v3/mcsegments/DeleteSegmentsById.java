/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Segments API
 * This API was deprecated on December 31, 2022. Following deprecation, all segments created in the Marketing Campaigns user interface began using the [Segmentation v2 API](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2).  To enable manual migration and data retrieval, this API's GET and DELETE operations will remain available. The POST (create) and PATCH (update) endpoints were removed on January 31, 2023 because it is no longer possible to create new v1 segments or modify existing ones. See our [Segmentation v1 to v2 upgrade instructions](https://docs.sendgrid.com/for-developers/sending-email/getting-started-the-marketing-campaigns-v2-segmentation-api#upgrade-a-v1-segment-to-v2) to manually migrate your segments to the v2 API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mcsegments;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiErrorResponse;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.mcsegments.models.ErrorResponse;
import com.sendgrid.rest.api.v3.mcsegments.models.GetMarketingSegments500Response;
import com.sendgrid.rest.api.v3.mcsegments.models.GetMarketingSegmentsSegmentId404Response;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteSegmentsById {
    private final UUID segmentId;


    public Object send(final TokenRestClient client) {
        String path = "/v3/marketing/segments/{segment_id}";
        Request.Builder builder = new Request.Builder(HttpMethod.DELETE, path)
                .addPathParam("segment_id", segmentId.toString());
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "DeleteSegmentsById creation failed: Unable to connect to server"
            );
        } else if (!TokenRestClient.SUCCESS.test(response.getStatusCode())) {

            int statusCode = response.getStatusCode();
            if (Matcher.matches(Integer.toString(statusCode), "400")) {
                ErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        ErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

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
                GetMarketingSegmentsSegmentId404Response error = JsonUtil.fromJson(
                        response.getStream(),
                        GetMarketingSegmentsSegmentId404Response.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "500")) {
                GetMarketingSegments500Response error = JsonUtil.fromJson(
                        response.getStream(),
                        GetMarketingSegments500Response.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

        }
        return JsonUtil.fromJson(response.getStream(), Object.class);
    }


}
