/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Contacts API
 * The Twilio SendGrid Marketing Campaigns Contacts API allows you to manage all of your marketing contacts programmatically. You can also import and export contacts using this API. The Contacts API allows you to associate contacts with lists and segments; however, to manage the lists and segments themselves, see the [Lists API](https://docs.sendgrid.com/api-reference/lists/) and [Segments API](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2/).  You can also manage your marketing contacts with the [Marketing Campaigns application user interface](https://mc.sendgrid.com/contacts). See [**How to Send Email with New Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/how-to-send-email-with-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mccontacts.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListContactCount200ResponseBillableBreakdown {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("total")
    @Getter
    @Setter
    private Integer total;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("breakdown")
    @Getter
    @Setter
    private Object breakdown;

    public ListContactCount200ResponseBillableBreakdown() {}

    private ListContactCount200ResponseBillableBreakdown(Builder builder) {
        this.total = builder.total;
        this.breakdown = builder.breakdown;
    }

    // Builder class for constructing object
    public static class Builder {

        private Integer total;
        private Object breakdown;

        public Builder() {}

        public Builder total(Integer total) {
            this.total = total;
            return this;
        }

        public Builder breakdown(Object breakdown) {
            this.breakdown = breakdown;
            return this;
        }

        public ListContactCount200ResponseBillableBreakdown build() {
            return new ListContactCount200ResponseBillableBreakdown(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListContactCount200ResponseBillableBreakdown.class.getSimpleName() +
            "(",
            ")"
        );
        if (total != null) joiner.add("total=" + total);
        if (breakdown != null) joiner.add("breakdown=" + breakdown);
        return joiner.toString();
    }
}