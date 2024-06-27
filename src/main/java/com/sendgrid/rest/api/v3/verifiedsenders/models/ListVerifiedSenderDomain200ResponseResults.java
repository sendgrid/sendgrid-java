/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Verified Senders API
 * The Twilio SendGrid Verified Senders API allows you to programmatically manage the Sender Identities that are authorized to send email for your account. You can also manage Sender Identities in the [SendGrid application user interface](https://app.sendgrid.com/settings/sender_auth). See [**Single Sender Verification**](https://sendgrid.com/docs/ui/sending-email/sender-verification/) for more information.  You an use this API to create new Sender Identities, retrieve a list of existing Sender Identities, check the status of a Sender Identity, update a Sender Identity, and delete a Sender Identity.  This API offers additional operations to check for domains known to implement DMARC and resend verification emails to Sender Identities that have yet to complete the verification process.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.verifiedsenders.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListVerifiedSenderDomain200ResponseResults {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("soft_failures")
    @Getter
    @Setter
    private List<String> softFailures;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("hard_failures")
    @Getter
    @Setter
    private List<String> hardFailures;

    public ListVerifiedSenderDomain200ResponseResults() {}

    private ListVerifiedSenderDomain200ResponseResults(Builder builder) {
        this.softFailures = builder.softFailures;
        this.hardFailures = builder.hardFailures;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<String> softFailures;
        private List<String> hardFailures;

        public Builder(List<String> softFailures, List<String> hardFailures) {
            this.softFailures = softFailures;
            this.hardFailures = hardFailures;
        }

        public ListVerifiedSenderDomain200ResponseResults build() {
            return new ListVerifiedSenderDomain200ResponseResults(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListVerifiedSenderDomain200ResponseResults.class.getSimpleName() +
            "(",
            ")"
        );
        if (softFailures != null) joiner.add("softFailures=" + softFailures);
        if (hardFailures != null) joiner.add("hardFailures=" + hardFailures);
        return joiner.toString();
    }
}