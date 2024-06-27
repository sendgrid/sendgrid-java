/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Scheduled Sends API
 * The Twilio SendGrid Scheduled Sends API allows you to cancel or pause the send of one or more emails using a batch ID.  A `batch_id` groups multiple scheduled mail send requests together with the same ID. You can cancel or pause all of the requests associated with a batch ID up to 10 minutes before the scheduled send time.  See [**Canceling a Scheduled Send**](https://docs.sendgrid.com/for-developers/sending-email/stopping-a-scheduled-send) for a guide on creating a `batch_id`, assigning it to a scheduled send, and modifying the send.  See the Mail API's batching operations to validate a `batch_id` and retrieve all scheduled sends as an array.  When a batch is canceled, all messages associated with that batch will stay in your sending queue. When their `send_at` value is reached, they will be discarded.  When a batch is paused, all messages associated with that batch will stay in your sending queue, even after their `send_at` value has passed. This means you can remove a pause status, and your scheduled send will be delivered once the pause is removed. Any messages left with a pause status that are more than 72 hours old will be discarded as Expired.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.scheduledsends.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.scheduledsends.models.Status1;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UpdateScheduledSendRequest {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("status")
    @Getter
    @Setter
    private Status1 status;

    public UpdateScheduledSendRequest() {}

    private UpdateScheduledSendRequest(Builder builder) {
        this.status = builder.status;
    }

    // Builder class for constructing object
    public static class Builder {

        private Status1 status;

        public Builder(Status1 status) {
            this.status = status;
        }

        public UpdateScheduledSendRequest build() {
            return new UpdateScheduledSendRequest(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            UpdateScheduledSendRequest.class.getSimpleName() + "(",
            ")"
        );
        if (status != null) joiner.add("status=" + status);
        return joiner.toString();
    }
}