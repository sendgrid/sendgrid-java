/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Webhook Configuration API
 * The Twilio SendGrid Webhooks API allows you to configure the Event and Parse Webhooks.  Email is a data-rich channel, and implementing the Event Webhook will allow you to consume those data in nearly real time. This means you can actively monitor and participate in the health of your email program throughout the send cycle.  The Inbound Parse Webhook processes all incoming email for a domain or subdomain, parses the contents and attachments and then POSTs `multipart/form-data` to a URL that you choose.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.webhooks.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class EventWebhookDateResponseProps {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("created_date")
    @Getter
    @Setter
    private OffsetDateTime createdDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("updated_date")
    @Getter
    @Setter
    private OffsetDateTime updatedDate;

    public EventWebhookDateResponseProps() {}

    private EventWebhookDateResponseProps(Builder builder) {
        this.createdDate = builder.createdDate;
        this.updatedDate = builder.updatedDate;
    }

    // Builder class for constructing object
    public static class Builder {

        private OffsetDateTime createdDate;
        private OffsetDateTime updatedDate;

        public Builder() {}

        public Builder createdDate(OffsetDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder updatedDate(OffsetDateTime updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public EventWebhookDateResponseProps build() {
            return new EventWebhookDateResponseProps(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            EventWebhookDateResponseProps.class.getSimpleName() + "(",
            ")"
        );
        if (createdDate != null) joiner.add("createdDate=" + createdDate);
        if (updatedDate != null) joiner.add("updatedDate=" + updatedDate);
        return joiner.toString();
    }
}