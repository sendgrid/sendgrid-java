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

import java.util.List;
import java.util.StringJoiner;


@ToString
public class PostAsmSuppressionsGlobal201Response {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("recipientEmails")
    @Getter
    @Setter
    private List<String> recipientEmails;

    public PostAsmSuppressionsGlobal201Response() {
    }

    private PostAsmSuppressionsGlobal201Response(Builder builder) {
        this.recipientEmails = builder.recipientEmails;
    }

    // Builder class for constructing object
    public static class Builder {
        private List<String> recipientEmails;

        public Builder(List<String> recipientEmails) {
            this.recipientEmails = recipientEmails;
        }

        public PostAsmSuppressionsGlobal201Response build() {
            return new PostAsmSuppressionsGlobal201Response(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", PostAsmSuppressionsGlobal201Response.class.getSimpleName() + "(", ")");
        if (recipientEmails != null) joiner.add("recipientEmails=" + recipientEmails);
        return joiner.toString();
    }

}
         
    
