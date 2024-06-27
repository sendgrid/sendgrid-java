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
import com.sendgrid.rest.api.v3.reversedns.models.Valid1;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ValidateReverseDns200ResponseValidationResultsARecord {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("valid")
    @Getter
    @Setter
    private Valid1 valid;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("reason")
    @Getter
    @Setter
    private String reason;

    public ValidateReverseDns200ResponseValidationResultsARecord() {}

    private ValidateReverseDns200ResponseValidationResultsARecord(
        Builder builder
    ) {
        this.valid = builder.valid;
        this.reason = builder.reason;
    }

    // Builder class for constructing object
    public static class Builder {

        private Valid1 valid;
        private String reason;

        public Builder(Valid1 valid, String reason) {
            this.valid = valid;
            this.reason = reason;
        }

        public ValidateReverseDns200ResponseValidationResultsARecord build() {
            return new ValidateReverseDns200ResponseValidationResultsARecord(
                this
            );
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ValidateReverseDns200ResponseValidationResultsARecord.class.getSimpleName() +
            "(",
            ")"
        );
        if (valid != null) joiner.add("valid=" + valid);
        if (reason != null) joiner.add("reason=" + reason);
        return joiner.toString();
    }
}