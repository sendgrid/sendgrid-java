/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Scopes API
 * The Twilio SendGrid Scopes API allows you to retrieve the scopes or permissions available to a user, see the user's attempts to access your SendGrid account, and, if necessary, deny an access request.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.scopes.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DenyScopeRequest404ResponseErrorsInner {

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

    public DenyScopeRequest404ResponseErrorsInner() {}

    private DenyScopeRequest404ResponseErrorsInner(Builder builder) {
        this.message = builder.message;
        this.field = builder.field;
    }

    // Builder class for constructing object
    public static class Builder {

        private String message;
        private String field;

        public Builder() {}

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public DenyScopeRequest404ResponseErrorsInner build() {
            return new DenyScopeRequest404ResponseErrorsInner(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            DenyScopeRequest404ResponseErrorsInner.class.getSimpleName() + "(",
            ")"
        );
        if (message != null) joiner.add("message=" + message);
        if (field != null) joiner.add("field=" + field);
        return joiner.toString();
    }
}