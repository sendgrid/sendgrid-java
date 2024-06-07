/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Designs
 * The Twilio SendGrid Designs API offers the ability to manage assets stored in the Twilio SendGrid [Design Library](https://mc.sendgrid.com/design-library/my-designs).  The Design Library is a feature-rich email layout tool and media repository. You can [build designs for all your marketing email needs](https://sendgrid.com/docs/ui/sending-email/working-with-marketing-campaigns-email-designs/), including Single Sends and Automations.  You can also duplicate and then modify one of the pre-built designs provided by Twilio SendGrid to get you started.  The Designs API provides a REST-like interface for creating new designs, retrieving a list of existing designs, duplicating or updating a design, and deleting a design.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mcdesigns.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;


@ToString
public class ApiErrors {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("errors")
    @Getter
    @Setter
    private List<ApiError> errors;

    public ApiErrors() {
    }

    private ApiErrors(Builder builder) {
        this.errors = builder.errors;
    }

    // Builder class for constructing object
    public static class Builder {
        private List<ApiError> errors;

        public Builder() {
        }

        public Builder errors(List<ApiError> errors) {
            this.errors = errors;
            return this;
        }

        public ApiErrors build() {
            return new ApiErrors(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", ApiErrors.class.getSimpleName() + "(", ")");
        if (errors != null) joiner.add("errors=" + errors);
        return joiner.toString();
    }

}
         
    
