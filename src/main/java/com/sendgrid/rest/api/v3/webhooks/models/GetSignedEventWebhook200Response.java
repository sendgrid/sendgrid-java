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
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GetSignedEventWebhook200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private String id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("public_key")
    @Getter
    @Setter
    private String publicKey;

    public GetSignedEventWebhook200Response() {}

    private GetSignedEventWebhook200Response(Builder builder) {
        this.id = builder.id;
        this.publicKey = builder.publicKey;
    }

    // Builder class for constructing object
    public static class Builder {

        private String id;
        private String publicKey;

        public Builder() {}

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder publicKey(String publicKey) {
            this.publicKey = publicKey;
            return this;
        }

        public GetSignedEventWebhook200Response build() {
            return new GetSignedEventWebhook200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            GetSignedEventWebhook200Response.class.getSimpleName() + "(",
            ")"
        );
        if (id != null) joiner.add("id=" + id);
        if (publicKey != null) joiner.add("publicKey=" + publicKey);
        return joiner.toString();
    }
}