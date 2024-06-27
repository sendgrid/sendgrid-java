/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Legacy Marketing Campaigns Sender Identities API
 * The Twilio SendGrid Legacy Marketing Campaigns Sender Identites API allows you to manage the email addresses used to send your marketing email. This API is operational, but we recommend using the current version of Marketing Campaigns to manage your [senders](https://docs.sendgrid.com/api-reference/senders/).  See [**Migrating from Legacy Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/migrating-from-legacy-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.lmcsenders.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SenderIdRequestReplyTo {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("email")
    @Getter
    @Setter
    private String email;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    public SenderIdRequestReplyTo() {}

    private SenderIdRequestReplyTo(Builder builder) {
        this.email = builder.email;
        this.name = builder.name;
    }

    // Builder class for constructing object
    public static class Builder {

        private String email;
        private String name;

        public Builder() {}

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public SenderIdRequestReplyTo build() {
            return new SenderIdRequestReplyTo(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            SenderIdRequestReplyTo.class.getSimpleName() + "(",
            ")"
        );
        if (email != null) joiner.add("email=" + email);
        if (name != null) joiner.add("name=" + name);
        return joiner.toString();
    }
}