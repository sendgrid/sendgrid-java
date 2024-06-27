/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Suppressions API
 * The Twilio SendGrid Suppressions API allows you to manage your Suppressions or Unsubscribes and Suppression or Unsubscribe groups. With SendGrid, an unsubscribe is the action an email recipient takes when they opt-out of receiving your messages. A suppression is the action you take as a sender to filter or suppress an unsubscribed address from your email send. From the perspective of the recipient, your suppression is the result of their unsubscribe.  You can have global suppressions, which represent addresses that have been unsubscribed from all of your emails. You can also have suppression groups, also known as ASM groups, which represent categories or groups of emails that your recipients can unsubscribe from, rather than unsubscribing from all of your messages.  SendGrid automatically suppresses emails sent to users for a variety of reasons, including blocks, bounces, invalid email addresses, spam reports, and unsubscribes. SendGrid suppresses these messages to help you maintain the best possible sender reputation by attempting to prevent unwanted mail. You may also add addresses to your suppressions.  See [**Suppressions**](https://docs.sendgrid.com/for-developers/sending-email/suppressions) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.suppressions.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UpdateAsmGroupRequest {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("description")
    @Getter
    @Setter
    private String description;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("is_default")
    @Getter
    @Setter
    private Boolean isDefault;

    public UpdateAsmGroupRequest() {}

    private UpdateAsmGroupRequest(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.isDefault = builder.isDefault;
    }

    // Builder class for constructing object
    public static class Builder {

        private String name;
        private String description;
        private Boolean isDefault;

        public Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder isDefault(Boolean isDefault) {
            this.isDefault = isDefault;
            return this;
        }

        public UpdateAsmGroupRequest build() {
            return new UpdateAsmGroupRequest(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            UpdateAsmGroupRequest.class.getSimpleName() + "(",
            ")"
        );
        if (name != null) joiner.add("name=" + name);
        if (description != null) joiner.add("description=" + description);
        if (isDefault != null) joiner.add("isDefault=" + isDefault);
        return joiner.toString();
    }
}