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
public class ParseSetting {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("url")
    @Getter
    @Setter
    private String url;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("hostname")
    @Getter
    @Setter
    private String hostname;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("spam_check")
    @Getter
    @Setter
    private Boolean spamCheck;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("send_raw")
    @Getter
    @Setter
    private Boolean sendRaw;

    public ParseSetting() {}

    private ParseSetting(Builder builder) {
        this.url = builder.url;
        this.hostname = builder.hostname;
        this.spamCheck = builder.spamCheck;
        this.sendRaw = builder.sendRaw;
    }

    // Builder class for constructing object
    public static class Builder {

        private String url;
        private String hostname;
        private Boolean spamCheck;
        private Boolean sendRaw;

        public Builder() {}

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder hostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        public Builder spamCheck(Boolean spamCheck) {
            this.spamCheck = spamCheck;
            return this;
        }

        public Builder sendRaw(Boolean sendRaw) {
            this.sendRaw = sendRaw;
            return this;
        }

        public ParseSetting build() {
            return new ParseSetting(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ParseSetting.class.getSimpleName() + "(",
            ")"
        );
        if (url != null) joiner.add("url=" + url);
        if (hostname != null) joiner.add("hostname=" + hostname);
        if (spamCheck != null) joiner.add("spamCheck=" + spamCheck);
        if (sendRaw != null) joiner.add("sendRaw=" + sendRaw);
        return joiner.toString();
    }
}