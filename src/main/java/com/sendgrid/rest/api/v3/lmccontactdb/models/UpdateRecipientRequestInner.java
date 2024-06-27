/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Legacy Marketing Campaigns Contacts API
 * The Twilio SendGrid Legacy Marketing Campaigns Contacts API allows you to manage your marketing contacts programmatically. This API is operational, but we recommend using the current version of Marketing Campaigns' [Contacts API](https://docs.sendgrid.com/api-reference/contacts/), [Lists API](https://docs.sendgrid.com/api-reference/lists/), and [Segments API](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2/) to manage your contacts.  See [**Migrating from Legacy Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/migrating-from-legacy-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.lmccontactdb.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UpdateRecipientRequestInner {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("email")
    @Getter
    @Setter
    private String email;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("last_name")
    @Getter
    @Setter
    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("first_name")
    @Getter
    @Setter
    private String firstName;

    public UpdateRecipientRequestInner() {}

    private UpdateRecipientRequestInner(Builder builder) {
        this.email = builder.email;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
    }

    // Builder class for constructing object
    public static class Builder {

        private String email;
        private String lastName;
        private String firstName;

        public Builder(String email) {
            this.email = email;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UpdateRecipientRequestInner build() {
            return new UpdateRecipientRequestInner(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            UpdateRecipientRequestInner.class.getSimpleName() + "(",
            ")"
        );
        if (email != null) joiner.add("email=" + email);
        if (lastName != null) joiner.add("lastName=" + lastName);
        if (firstName != null) joiner.add("firstName=" + firstName);
        return joiner.toString();
    }
}