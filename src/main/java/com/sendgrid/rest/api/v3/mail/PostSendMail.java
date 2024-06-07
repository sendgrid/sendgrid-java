/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Mail API
 * The Twilio SendGrid v3 Mail API allows you to send email at scale over HTTP. The Mail Send endpoint supports many levels of functionality, allowing you to send templates, set categories and custom arguments that can be used to analyze your send, and configure which tracking settings to include such as opens and clicks. You can also group mail sends into batches, allowing you to schedule and cancel sends by their batch IDs.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mail;

import com.sendgrid.exception.ApiConnectionException;
import com.sendgrid.exception.ApiErrorResponse;
import com.sendgrid.http.HttpMethod;
import com.sendgrid.http.Request;
import com.sendgrid.http.Response;
import com.sendgrid.http.TokenRestClient;
import com.sendgrid.rest.api.v3.mail.models.ErrorResponse;
import com.sendgrid.rest.api.v3.mail.models.PostMailSendRequest;
import com.sendgrid.util.JsonUtil;
import com.sendgrid.util.Matcher;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostSendMail {
    private Schema contentEncoding;
    private final PostMailSendRequest postMailSendRequest;


    public void send(final TokenRestClient client) {
        String path = "/v3/mail/send";
        Request.Builder builder = new Request.Builder(HttpMethod.POST, path);
        addHeaderParams(builder);
        body(builder);
        Request request = builder.build();
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException(
                    "PostSendMail creation failed: Unable to connect to server"
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
                ErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        ErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "405")) {
                ErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        ErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "413")) {
                ErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        ErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

            if (Matcher.matches(Integer.toString(statusCode), "500")) {
                ErrorResponse error = JsonUtil.fromJson(
                        response.getStream(),
                        ErrorResponse.class
                );
                throw new ApiErrorResponse(statusCode, null, error, response.getHeaders());
            }

        }
        return;
    }


    private void addHeaderParams(Request.Builder builder) {
        if (contentEncoding != null) {
            builder.addHeaderParams("Content-Encoding", contentEncoding.toString());
        }

    }


    private void body(final Request.Builder builder) {
        if (postMailSendRequest != null) {
            builder.body(JsonUtil.toJson(postMailSendRequest));
        }
    }

}
