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
import com.sendgrid.rest.api.v3.mcsinglesends.models.AbTestSummary;
import com.sendgrid.rest.api.v3.mcsinglesends.models.Status3;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SinglesendResponseShort {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private UUID id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("abtest")
    @Getter
    @Setter
    private AbTestSummary abtest;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("status")
    @Getter
    @Setter
    private Status3 status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("categories")
    @Getter
    @Setter
    private List<String> categories;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("send_at")
    @Getter
    @Setter
    private OffsetDateTime sendAt;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("is_abtest")
    @Getter
    @Setter
    private Boolean isAbtest;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("updated_at")
    @Getter
    @Setter
    private OffsetDateTime updatedAt;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("created_at")
    @Getter
    @Setter
    private OffsetDateTime createdAt;

    public SinglesendResponseShort() {}

    private SinglesendResponseShort(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.abtest = builder.abtest;
        this.status = builder.status;
        this.categories = builder.categories;
        this.sendAt = builder.sendAt;
        this.isAbtest = builder.isAbtest;
        this.updatedAt = builder.updatedAt;
        this.createdAt = builder.createdAt;
    }

    // Builder class for constructing object
    public static class Builder {

        private UUID id;
        private String name;
        private AbTestSummary abtest;
        private Status3 status;
        private List<String> categories;
        private OffsetDateTime sendAt;
        private Boolean isAbtest;
        private OffsetDateTime updatedAt;
        private OffsetDateTime createdAt;

        public Builder(
            UUID id,
            String name,
            AbTestSummary abtest,
            Status3 status,
            List<String> categories,
            Boolean isAbtest,
            OffsetDateTime updatedAt,
            OffsetDateTime createdAt
        ) {
            this.id = id;
            this.name = name;
            this.abtest = abtest;
            this.status = status;
            this.categories = categories;
            this.isAbtest = isAbtest;
            this.updatedAt = updatedAt;
            this.createdAt = createdAt;
        }

        public Builder sendAt(OffsetDateTime sendAt) {
            this.sendAt = sendAt;
            return this;
        }

        public SinglesendResponseShort build() {
            return new SinglesendResponseShort(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            SinglesendResponseShort.class.getSimpleName() + "(",
            ")"
        );
        if (id != null) joiner.add("id=" + id);
        if (name != null) joiner.add("name=" + name);
        if (abtest != null) joiner.add("abtest=" + abtest);
        if (status != null) joiner.add("status=" + status);
        if (categories != null) joiner.add("categories=" + categories);
        if (sendAt != null) joiner.add("sendAt=" + sendAt);
        if (isAbtest != null) joiner.add("isAbtest=" + isAbtest);
        if (updatedAt != null) joiner.add("updatedAt=" + updatedAt);
        if (createdAt != null) joiner.add("createdAt=" + createdAt);
        return joiner.toString();
    }
}