/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Reverse DNS API
 * The Twilio SendGrid Reverse DNS API (formerly IP Whitelabel) allows you to configure reverse DNS settings for your account. Mailbox providers verify the sender of your emails by performing a reverse DNS lookup.  When setting up Reverse DNS, Twilio SendGrid will provide an A Record (address record) for you to add to the DNS records of your sending domain. The A record maps your sending domain to a dedicated Twilio SendGrid IP address. Once Twilio SendGrid has verified that the appropriate A record for the IP address has been created, the appropriate reverse DNS record for the IP address is generated.  Reverse DNS is available for [dedicated IP addresses](https://sendgrid.com/docs/ui/account-and-settings/dedicated-ip-addresses/) only.  You can also manage your reverse DNS settings in the Sender Authentication setion of the [Twilio SendGrid application user interface](https://app.sendgrid.com/settings/sender_auth).  See [**How to Set Up Reverse DNS**](https://sendgrid.com/docs/ui/account-and-settings/how-to-set-up-reverse-dns/) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.reversedns.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.reversedns.models.Valid;
import com.sendgrid.rest.api.v3.reversedns.models.ValidateReverseDns200ResponseValidationResults;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ValidateReverseDns200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("valid")
    @Getter
    @Setter
    private Valid valid;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("validation_results")
    @Getter
    @Setter
    private ValidateReverseDns200ResponseValidationResults validationResults;

    public ValidateReverseDns200Response() {}

    private ValidateReverseDns200Response(Builder builder) {
        this.id = builder.id;
        this.valid = builder.valid;
        this.validationResults = builder.validationResults;
    }

    // Builder class for constructing object
    public static class Builder {

        private Integer id;
        private Valid valid;
        private ValidateReverseDns200ResponseValidationResults validationResults;

        public Builder(
            Integer id,
            Valid valid,
            ValidateReverseDns200ResponseValidationResults validationResults
        ) {
            this.id = id;
            this.valid = valid;
            this.validationResults = validationResults;
        }

        public ValidateReverseDns200Response build() {
            return new ValidateReverseDns200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ValidateReverseDns200Response.class.getSimpleName() + "(",
            ")"
        );
        if (id != null) joiner.add("id=" + id);
        if (valid != null) joiner.add("valid=" + valid);
        if (validationResults != null) joiner.add(
            "validationResults=" + validationResults
        );
        return joiner.toString();
    }
}