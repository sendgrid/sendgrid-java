/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Legacy Marketing Campaigns Campaigns API
 * The Twilio SendGrid Legacy Marketing Campaigns Campaigns API allows you to manage your marketing email messages programmatically. This API is operational, but we recommend using the current version of Marketing Campaigns to manage your marketing messages with SendGrid [Single Sends](https://docs.sendgrid.com/api-reference/single-sends/) and [Automations](https://docs.sendgrid.com/ui/sending-email/getting-started-with-automation).  See [**Migrating from Legacy Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/migrating-from-legacy-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.lmccampaigns.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UpdateAScheduledCampaignRequest {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("send_at")
    @Getter
    @Setter
    private Long sendAt;

    public UpdateAScheduledCampaignRequest() {}

    private UpdateAScheduledCampaignRequest(Builder builder) {
        this.sendAt = builder.sendAt;
    }

    // Builder class for constructing object
    public static class Builder {

        private Long sendAt;

        public Builder(Long sendAt) {
            this.sendAt = sendAt;
        }

        public UpdateAScheduledCampaignRequest build() {
            return new UpdateAScheduledCampaignRequest(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            UpdateAScheduledCampaignRequest.class.getSimpleName() + "(",
            ")"
        );
        if (sendAt != null) joiner.add("sendAt=" + sendAt);
        return joiner.toString();
    }
}