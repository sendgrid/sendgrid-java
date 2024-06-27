/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Reverse DNS API
 * The Twilio SendGrid Reverse DNS API (formerly IP Whitelabel) allows you to configure reverse DNS settings for your account. Mailbox providers verify the sender of your emails by performing a reverse DNS lookup.  When setting up Reverse DNS, Twilio SendGrid will provide an A Record (address record) for you to add to the DNS records of your sending domain. The A record maps your sending domain to a dedicated Twilio SendGrid IP address. Once Twilio SendGrid has verified that the appropriate A record for the IP address has been created, the appropriate reverse DNS record for the IP address is generated.  Reverse DNS is available for [dedicated IP addresses](https://sendgrid.com/docs/ui/account-and-settings/dedicated-ip-addresses/) only.  You can also manage your reverse DNS settings in the Sender Authentication setion of the [Twilio SendGrid application user interface](https://app.sendgrid.com/settings/sender_auth).  See [**How to Set Up Reverse DNS**](https://sendgrid.com/docs/ui/account-and-settings/how-to-set-up-reverse-dns/) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.reversedns.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ReverseDnsARecord {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("valid")
    @Getter
    @Setter
    private Boolean valid;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("type")
    @Getter
    @Setter
    private String type;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("host")
    @Getter
    @Setter
    private String host;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("data")
    @Getter
    @Setter
    private String data;

    public ReverseDnsARecord() {}

    private ReverseDnsARecord(Builder builder) {
        this.valid = builder.valid;
        this.type = builder.type;
        this.host = builder.host;
        this.data = builder.data;
    }

    // Builder class for constructing object
    public static class Builder {

        private Boolean valid;
        private String type;
        private String host;
        private String data;

        public Builder(Boolean valid, String type, String host, String data) {
            this.valid = valid;
            this.type = type;
            this.host = host;
            this.data = data;
        }

        public ReverseDnsARecord build() {
            return new ReverseDnsARecord(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ReverseDnsARecord.class.getSimpleName() + "(",
            ")"
        );
        if (valid != null) joiner.add("valid=" + valid);
        if (type != null) joiner.add("type=" + type);
        if (host != null) joiner.add("host=" + host);
        if (data != null) joiner.add("data=" + data);
        return joiner.toString();
    }
}
