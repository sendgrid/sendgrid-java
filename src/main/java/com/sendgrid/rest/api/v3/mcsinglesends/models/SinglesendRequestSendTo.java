/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Single Sends API
 * The Twilio SendGrid Single Sends API allows you to create, manage, and send Single Sends. You can also search Single Sends and retrieve statistics about them to help you maintain, alter, and further develop your campaigns.  A Single Send is a one-time non-automated email message delivered to a list or segment of your audience. A Single Send may be sent immediately or scheduled for future delivery.  Single Sends can serve many use cases, including promotional offers, engagement campaigns, newsletters, announcements, legal notices, or policy updates. You can also create and manage Single Sends in the [Marketing Campaigns application user interface](https://mc.sendgrid.com/single-sends).  The Single Sends API changed on May 6, 2020. See [**Single Sends 2020 Update**](https://docs.sendgrid.com/for-developers/sending-email/single-sends-2020-update) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mcsinglesends.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SinglesendRequestSendTo {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("list_ids")
    @Getter
    @Setter
    private List<UUID> listIds;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("segment_ids")
    @Getter
    @Setter
    private List<UUID> segmentIds;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("all")
    @Getter
    @Setter
    private Boolean all;

    public SinglesendRequestSendTo() {}

    private SinglesendRequestSendTo(Builder builder) {
        this.listIds = builder.listIds;
        this.segmentIds = builder.segmentIds;
        this.all = builder.all;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<UUID> listIds;
        private List<UUID> segmentIds;
        private Boolean all;

        public Builder() {}

        public Builder listIds(List<UUID> listIds) {
            this.listIds = listIds;
            return this;
        }

        public Builder segmentIds(List<UUID> segmentIds) {
            this.segmentIds = segmentIds;
            return this;
        }

        public Builder all(Boolean all) {
            this.all = all;
            return this;
        }

        public SinglesendRequestSendTo build() {
            return new SinglesendRequestSendTo(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            SinglesendRequestSendTo.class.getSimpleName() + "(",
            ")"
        );
        if (listIds != null) joiner.add("listIds=" + listIds);
        if (segmentIds != null) joiner.add("segmentIds=" + segmentIds);
        if (all != null) joiner.add("all=" + all);
        return joiner.toString();
    }
}