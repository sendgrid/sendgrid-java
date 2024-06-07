/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Email Activity API
 * The Twilio SendGrid Email Activity API allows you to query all of your stored messages, query individual messages, and download a CSV with data about the stored messages. Once retrieved, you can inspect the data associated with your messages to better understand your mail send. For example, you may retrieve all bounced messages or all messages with the same subject line and search for commonalities among them.  You must [purchase additional email activity history](https://app.sendgrid.com/settings/billing/addons/email_activity) to gain access to the Email Activity Feed API.  See **Getting Started with the Email Activity Feed API** for help building queries and working with this API. You can also work with email activity in the **Activity** section of the [Twilio SendGrid application user interface](https://app.sendgrid.com/email_activity).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.emailactivity.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class GetMessages429ResponseErrorsInner {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("message")
    @Getter
    @Setter
    private String message;

    public GetMessages429ResponseErrorsInner() {
    }

    private GetMessages429ResponseErrorsInner(Builder builder) {
        this.message = builder.message;
    }

    // Builder class for constructing object
    public static class Builder {
        private String message;

        public Builder() {
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public GetMessages429ResponseErrorsInner build() {
            return new GetMessages429ResponseErrorsInner(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", GetMessages429ResponseErrorsInner.class.getSimpleName() + "(", ")");
        if (message != null) joiner.add("message=" + message);
        return joiner.toString();
    }

}
         
    
