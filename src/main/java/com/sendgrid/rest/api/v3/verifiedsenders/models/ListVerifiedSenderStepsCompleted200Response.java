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
import com.sendgrid.rest.api.v3.verifiedsenders.models.ListVerifiedSenderStepsCompleted200ResponseResults;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListVerifiedSenderStepsCompleted200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("results")
    @Getter
    @Setter
    private ListVerifiedSenderStepsCompleted200ResponseResults results;

    public ListVerifiedSenderStepsCompleted200Response() {}

    private ListVerifiedSenderStepsCompleted200Response(Builder builder) {
        this.results = builder.results;
    }

    // Builder class for constructing object
    public static class Builder {

        private ListVerifiedSenderStepsCompleted200ResponseResults results;

        public Builder() {}

        public Builder results(
            ListVerifiedSenderStepsCompleted200ResponseResults results
        ) {
            this.results = results;
            return this;
        }

        public ListVerifiedSenderStepsCompleted200Response build() {
            return new ListVerifiedSenderStepsCompleted200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListVerifiedSenderStepsCompleted200Response.class.getSimpleName() +
            "(",
            ")"
        );
        if (results != null) joiner.add("results=" + results);
        return joiner.toString();
    }
}
