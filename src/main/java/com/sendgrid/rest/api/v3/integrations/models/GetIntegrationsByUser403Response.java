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
import com.sendgrid.rest.api.v3.integrations.models.Forbidden;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GetIntegrationsByUser403Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("errors")
    @Getter
    @Setter
    private List<Forbidden> errors;

    public GetIntegrationsByUser403Response() {}

    private GetIntegrationsByUser403Response(Builder builder) {
        this.errors = builder.errors;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<Forbidden> errors;

        public Builder() {}

        public Builder errors(List<Forbidden> errors) {
            this.errors = errors;
            return this;
        }

        public GetIntegrationsByUser403Response build() {
            return new GetIntegrationsByUser403Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            GetIntegrationsByUser403Response.class.getSimpleName() + "(",
            ")"
        );
        if (errors != null) joiner.add("errors=" + errors);
        return joiner.toString();
    }
}
