/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Link Branding API
 * The Twilio SendGrid Link Branding API allows you to configure your domain settings so that all of the click-tracked links, opens, and images in your emails are served from your domain rather than `sendgrid.net`. Spam filters and recipient servers look at the links within emails to determine whether the email appear trustworthy. They use the reputation of the root domain to determine whether the links can be trusted.  You can also manage Link Branding in the **Sender Authentication** section of the Twilio SendGrid application user interface.   See [**How to Set Up Link Branding**](https: //sendgrid.com/docs/ui/account-and-settings/how-to-set-up-link-branding/) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.linkbranding.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.linkbranding.models.Valid2;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ValidateBrandedLink200ResponseValidationResultsOwnerCname {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("valid")
    @Getter
    @Setter
    private Valid2 valid;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("reason")
    @Getter
    @Setter
    private String reason;

    public ValidateBrandedLink200ResponseValidationResultsOwnerCname() {}

    private ValidateBrandedLink200ResponseValidationResultsOwnerCname(
        Builder builder
    ) {
        this.valid = builder.valid;
        this.reason = builder.reason;
    }

    // Builder class for constructing object
    public static class Builder {

        private Valid2 valid;
        private String reason;

        public Builder(Valid2 valid, String reason) {
            this.valid = valid;
            this.reason = reason;
        }

        public ValidateBrandedLink200ResponseValidationResultsOwnerCname build() {
            return new ValidateBrandedLink200ResponseValidationResultsOwnerCname(
                this
            );
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ValidateBrandedLink200ResponseValidationResultsOwnerCname.class.getSimpleName() +
            "(",
            ")"
        );
        if (valid != null) joiner.add("valid=" + valid);
        if (reason != null) joiner.add("reason=" + reason);
        return joiner.toString();
    }
}
