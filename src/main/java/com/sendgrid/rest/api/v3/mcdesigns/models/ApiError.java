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
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ApiError {

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
    @JsonProperty("error_id")
    @Getter
    @Setter
    private String errorId;

    public ApiError() {}

    private ApiError(Builder builder) {
        this.message = builder.message;
        this.field = builder.field;
        this.errorId = builder.errorId;
    }

    // Builder class for constructing object
    public static class Builder {

        private String message;
        private String field;
        private String errorId;

        public Builder(String message, String field, String errorId) {
            this.message = message;
            this.field = field;
            this.errorId = errorId;
        }

        public ApiError build() {
            return new ApiError(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ApiError.class.getSimpleName() + "(",
            ")"
        );
        if (message != null) joiner.add("message=" + message);
        if (field != null) joiner.add("field=" + field);
        if (errorId != null) joiner.add("errorId=" + errorId);
        return joiner.toString();
    }
}
