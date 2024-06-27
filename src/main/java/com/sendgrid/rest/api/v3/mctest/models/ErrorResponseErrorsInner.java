/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Send Test Email API
 * The Twilio SendGrid Test Email API allows you to test a marketing email by first sending it to a list of up to 10 email addresses before pushing to a contact list or segment. With this feature, you can test the layout and content of your message in multiple email clients and with multiple recipients to see how it will function in a real-world scenario.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mctest.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    public ErrorResponseErrorsInner() {}

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

        public Builder() {}

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
        StringJoiner joiner = new StringJoiner(
            ", ",
            ErrorResponseErrorsInner.class.getSimpleName() + "(",
            ")"
        );
        if (message != null) joiner.add("message=" + message);
        if (field != null) joiner.add("field=" + field);
        if (help != null) joiner.add("help=" + help);
        return joiner.toString();
    }
}