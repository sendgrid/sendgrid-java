/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Verified Senders API
 * The Twilio SendGrid Verified Senders API allows you to programmatically manage the Sender Identities that are authorized to send email for your account. You can also manage Sender Identities in the [SendGrid application user interface](https://app.sendgrid.com/settings/sender_auth). See [**Single Sender Verification**](https://sendgrid.com/docs/ui/sending-email/sender-verification/) for more information.  You an use this API to create new Sender Identities, retrieve a list of existing Sender Identities, check the status of a Sender Identity, update a Sender Identity, and delete a Sender Identity.  This API offers additional operations to check for domains known to implement DMARC and resend verification emails to Sender Identities that have yet to complete the verification process.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.verifiedsenders.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class VerifiedSenderResponse {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("nickname")
    @Getter
    @Setter
    private String nickname;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("from_email")
    @Getter
    @Setter
    private String fromEmail;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("from_name")
    @Getter
    @Setter
    private String fromName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("reply_to")
    @Getter
    @Setter
    private String replyTo;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("reply_to_name")
    @Getter
    @Setter
    private String replyToName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("address")
    @Getter
    @Setter
    private String address;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("address2")
    @Getter
    @Setter
    private String address2;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("state")
    @Getter
    @Setter
    private String state;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("city")
    @Getter
    @Setter
    private String city;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("zip")
    @Getter
    @Setter
    private String zip;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("country")
    @Getter
    @Setter
    private String country;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("verified")
    @Getter
    @Setter
    private Boolean verified;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("locked")
    @Getter
    @Setter
    private Boolean locked;

    public VerifiedSenderResponse() {}

    private VerifiedSenderResponse(Builder builder) {
        this.id = builder.id;
        this.nickname = builder.nickname;
        this.fromEmail = builder.fromEmail;
        this.fromName = builder.fromName;
        this.replyTo = builder.replyTo;
        this.replyToName = builder.replyToName;
        this.address = builder.address;
        this.address2 = builder.address2;
        this.state = builder.state;
        this.city = builder.city;
        this.zip = builder.zip;
        this.country = builder.country;
        this.verified = builder.verified;
        this.locked = builder.locked;
    }

    // Builder class for constructing object
    public static class Builder {

        private Integer id;
        private String nickname;
        private String fromEmail;
        private String fromName;
        private String replyTo;
        private String replyToName;
        private String address;
        private String address2;
        private String state;
        private String city;
        private String zip;
        private String country;
        private Boolean verified;
        private Boolean locked;

        public Builder() {}

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder fromEmail(String fromEmail) {
            this.fromEmail = fromEmail;
            return this;
        }

        public Builder fromName(String fromName) {
            this.fromName = fromName;
            return this;
        }

        public Builder replyTo(String replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public Builder replyToName(String replyToName) {
            this.replyToName = replyToName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder address2(String address2) {
            this.address2 = address2;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder zip(String zip) {
            this.zip = zip;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder verified(Boolean verified) {
            this.verified = verified;
            return this;
        }

        public Builder locked(Boolean locked) {
            this.locked = locked;
            return this;
        }

        public VerifiedSenderResponse build() {
            return new VerifiedSenderResponse(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            VerifiedSenderResponse.class.getSimpleName() + "(",
            ")"
        );
        if (id != null) joiner.add("id=" + id);
        if (nickname != null) joiner.add("nickname=" + nickname);
        if (fromEmail != null) joiner.add("fromEmail=" + fromEmail);
        if (fromName != null) joiner.add("fromName=" + fromName);
        if (replyTo != null) joiner.add("replyTo=" + replyTo);
        if (replyToName != null) joiner.add("replyToName=" + replyToName);
        if (address != null) joiner.add("address=" + address);
        if (address2 != null) joiner.add("address2=" + address2);
        if (state != null) joiner.add("state=" + state);
        if (city != null) joiner.add("city=" + city);
        if (zip != null) joiner.add("zip=" + zip);
        if (country != null) joiner.add("country=" + country);
        if (verified != null) joiner.add("verified=" + verified);
        if (locked != null) joiner.add("locked=" + locked);
        return joiner.toString();
    }
}