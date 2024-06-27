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
public class ListScope401ResponseErrorsInner {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("field")
    @Getter
    @Setter
    private String field;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("message")
    @Getter
    @Setter
    private String message;

    public ListScope401ResponseErrorsInner() {}

    private ListScope401ResponseErrorsInner(Builder builder) {
        this.field = builder.field;
        this.message = builder.message;
    }

    // Builder class for constructing object
    public static class Builder {

        private String field;
        private String message;

        public Builder(String message) {
            this.message = message;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public ListScope401ResponseErrorsInner build() {
            return new ListScope401ResponseErrorsInner(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListScope401ResponseErrorsInner.class.getSimpleName() + "(",
            ")"
        );
        if (field != null) joiner.add("field=" + field);
        if (message != null) joiner.add("message=" + message);
        return joiner.toString();
    }
}