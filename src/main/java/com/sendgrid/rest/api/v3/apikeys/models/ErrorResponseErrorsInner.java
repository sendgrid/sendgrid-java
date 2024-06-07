/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid API Keys API
 * The Twilio SendGrid API Keys API allows you manage your API keys and their settings. Your application, mail client, or website can all use API keys to authenticate access to SendGrid services.  To create your initial SendGrid API Key, you should use the [SendGrid application user interface](https://app.sendgrid.com/settings/api_keys). Once you have created a first key with scopes to manage additional API keys, you can use this API for all other key management.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.apikeys.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class ErrorResponseErrorsInner {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("message")
    @Getter
    @Setter
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("field")
    @Getter
    @Setter
    private String field;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("help")
    @Getter
    @Setter
    private Object help;

    public ErrorResponseErrorsInner() {
    }

    private ErrorResponseErrorsInner(Builder builder) {
        this.message = builder.message;
        this.field = builder.field;
        this.help = builder.help;
    }

    // Builder class for constructing object
    public static class Builder {
        private String message;
        private String field;
        private Object help;

        public Builder() {
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder help(Object help) {
            this.help = help;
            return this;
        }

        public ErrorResponseErrorsInner build() {
            return new ErrorResponseErrorsInner(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", ErrorResponseErrorsInner.class.getSimpleName() + "(", ")");
        if (message != null) joiner.add("message=" + message);
        if (field != null) joiner.add("field=" + field);
        if (help != null) joiner.add("help=" + help);
        return joiner.toString();
    }

}
         
    
