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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.StringJoiner;


@ToString
public class SuppressionGroup {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private BigDecimal id;
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
    @JsonProperty("lastEmailSentAt")
    @Getter
    @Setter
    private Integer lastEmailSentAt;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("isDefault")
    @Getter
    @Setter
    private Boolean isDefault;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("unsubscribes")
    @Getter
    @Setter
    private Integer unsubscribes;

    public SuppressionGroup() {
    }

    private SuppressionGroup(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.lastEmailSentAt = builder.lastEmailSentAt;
        this.isDefault = builder.isDefault;
        this.unsubscribes = builder.unsubscribes;
    }

    // Builder class for constructing object
    public static class Builder {
        private BigDecimal id;
        private String name;
        private String description;
        private Integer lastEmailSentAt;
        private Boolean isDefault;
        private Integer unsubscribes;

        public Builder(BigDecimal id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        public Builder lastEmailSentAt(Integer lastEmailSentAt) {
            this.lastEmailSentAt = lastEmailSentAt;
            return this;
        }

        public Builder isDefault(Boolean isDefault) {
            this.isDefault = isDefault;
            return this;
        }

        public Builder unsubscribes(Integer unsubscribes) {
            this.unsubscribes = unsubscribes;
            return this;
        }

        public SuppressionGroup build() {
            return new SuppressionGroup(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", SuppressionGroup.class.getSimpleName() + "(", ")");
        if (id != null) joiner.add("id=" + id);
        if (name != null) joiner.add("name=" + name);
        if (description != null) joiner.add("description=" + description);
        if (lastEmailSentAt != null) joiner.add("lastEmailSentAt=" + lastEmailSentAt);
        if (isDefault != null) joiner.add("isDefault=" + isDefault);
        if (unsubscribes != null) joiner.add("unsubscribes=" + unsubscribes);
        return joiner.toString();
    }

}
         
    
