/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Integrations API
 * Integrations allows you to connect your SendGrid applications with third-party services and forward SendGrid email events to those external applications. Currently, Integrations supports event forwarding to [Segment](https://segment.com/docs). You can use this API to create, delete, view, and update your Integrations.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.integrations.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.integrations.models.InvalidDeleteRequest;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DeleteIntegration400Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("errors")
    @Getter
    @Setter
    private List<InvalidDeleteRequest> errors;

    public DeleteIntegration400Response() {}

    private DeleteIntegration400Response(Builder builder) {
        this.errors = builder.errors;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<InvalidDeleteRequest> errors;

        public Builder() {}

        public Builder errors(List<InvalidDeleteRequest> errors) {
            this.errors = errors;
            return this;
        }

        public DeleteIntegration400Response build() {
            return new DeleteIntegration400Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            DeleteIntegration400Response.class.getSimpleName() + "(",
            ")"
        );
        if (errors != null) joiner.add("errors=" + errors);
        return joiner.toString();
    }
}