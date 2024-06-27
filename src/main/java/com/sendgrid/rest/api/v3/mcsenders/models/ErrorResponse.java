/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Senders API
 * The Twilio SendGrid Marketing Campaigns Senders API allows you to create a verified sender from which your marketing emails will be sent. To ensure our customers maintain the best possible sender reputations and to uphold legitimate sending behavior, we require customers to verify their Senders. A Sender represents your “From” email address—the address your recipients will see as the sender of your emails.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mcsenders.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.mcsenders.models.ErrorResponseErrorsInner;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ErrorResponse {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("errors")
    @Getter
    @Setter
    private List<ErrorResponseErrorsInner> errors;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private String id;

    public ErrorResponse() {}

    private ErrorResponse(Builder builder) {
        this.errors = builder.errors;
        this.id = builder.id;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<ErrorResponseErrorsInner> errors;
        private String id;

        public Builder() {}

        public Builder errors(List<ErrorResponseErrorsInner> errors) {
            this.errors = errors;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ErrorResponse.class.getSimpleName() + "(",
            ")"
        );
        if (errors != null) joiner.add("errors=" + errors);
        if (id != null) joiner.add("id=" + id);
        return joiner.toString();
    }
}
