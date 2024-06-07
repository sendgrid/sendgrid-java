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

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Classification {

    CONTENT("Content"),

    FREQUENCY_OR_VOLUME_TOO_HIGH("Frequency or Volume Too High"),

    INVALID_ADDRESS("Invalid Address"),

    MAILBOX_UNAVAILABLE("Mailbox Unavailable"),

    REPUTATION("Reputation"),

    TECHNICAL_FAILURE("Technical Failure"),

    UNCLASSIFIED("Unclassified");

    private final String value;

    private Classification(final String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    @JsonCreator
    public static Classification fromString(final String value) {
        return CustomDeserializer. enum (value, Classification.values());
    }

}
