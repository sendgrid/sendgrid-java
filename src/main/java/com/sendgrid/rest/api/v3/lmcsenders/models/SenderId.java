/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Legacy Marketing Campaigns Sender Identities API
 * The Twilio SendGrid Legacy Marketing Campaigns Sender Identites API allows you to manage the email addresses used to send your marketing email. This API is operational, but we recommend using the current version of Marketing Campaigns to manage your [senders](https://docs.sendgrid.com/api-reference/senders/).  See [**Migrating from Legacy Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/migrating-from-legacy-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.lmcsenders.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.lmcsenders.models.SenderIdRequestFrom;
import com.sendgrid.rest.api.v3.lmcsenders.models.SenderIdRequestReplyTo;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SenderId {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("nickname")
    @Getter
    @Setter
    private String nickname;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("from")
    @Getter
    @Setter
    private SenderIdRequestFrom from;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("reply_to")
    @Getter
    @Setter
    private SenderIdRequestReplyTo replyTo;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("address")
    @Getter
    @Setter
    private String address;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("address_2")
    @Getter
    @Setter
    private String address2;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("city")
    @Getter
    @Setter
    private String city;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("state")
    @Getter
    @Setter
    private String state;

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
    @JsonProperty("id")
    @Getter
    @Setter
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("verified")
    @Getter
    @Setter
    private Boolean verified;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("updated_at")
    @Getter
    @Setter
    private Integer updatedAt;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("created_at")
    @Getter
    @Setter
    private Integer createdAt;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("locked")
    @Getter
    @Setter
    private Boolean locked;

    public SenderId() {}

    private SenderId(Builder builder) {
        this.nickname = builder.nickname;
        this.from = builder.from;
        this.replyTo = builder.replyTo;
        this.address = builder.address;
        this.address2 = builder.address2;
        this.city = builder.city;
        this.state = builder.state;
        this.zip = builder.zip;
        this.country = builder.country;
        this.id = builder.id;
        this.verified = builder.verified;
        this.updatedAt = builder.updatedAt;
        this.createdAt = builder.createdAt;
        this.locked = builder.locked;
    }

    // Builder class for constructing object
    public static class Builder {

        private String nickname;
        private SenderIdRequestFrom from;
        private SenderIdRequestReplyTo replyTo;
        private String address;
        private String address2;
        private String city;
        private String state;
        private String zip;
        private String country;
        private Integer id;
        private Boolean verified;
        private Integer updatedAt;
        private Integer createdAt;
        private Boolean locked;

        public Builder(
            String nickname,
            String address,
            String city,
            String country
        ) {
            this.nickname = nickname;
            this.address = address;
            this.city = city;
            this.country = country;
        }

        public Builder from(SenderIdRequestFrom from) {
            this.from = from;
            return this;
        }

        public Builder replyTo(SenderIdRequestReplyTo replyTo) {
            this.replyTo = replyTo;
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

        public Builder zip(String zip) {
            this.zip = zip;
            return this;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder verified(Boolean verified) {
            this.verified = verified;
            return this;
        }

        public Builder updatedAt(Integer updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder createdAt(Integer createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder locked(Boolean locked) {
            this.locked = locked;
            return this;
        }

        public SenderId build() {
            return new SenderId(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            SenderId.class.getSimpleName() + "(",
            ")"
        );
        if (nickname != null) joiner.add("nickname=" + nickname);
        if (from != null) joiner.add("from=" + from);
        if (replyTo != null) joiner.add("replyTo=" + replyTo);
        if (address != null) joiner.add("address=" + address);
        if (address2 != null) joiner.add("address2=" + address2);
        if (city != null) joiner.add("city=" + city);
        if (state != null) joiner.add("state=" + state);
        if (zip != null) joiner.add("zip=" + zip);
        if (country != null) joiner.add("country=" + country);
        if (id != null) joiner.add("id=" + id);
        if (verified != null) joiner.add("verified=" + verified);
        if (updatedAt != null) joiner.add("updatedAt=" + updatedAt);
        if (createdAt != null) joiner.add("createdAt=" + createdAt);
        if (locked != null) joiner.add("locked=" + locked);
        return joiner.toString();
    }
}
