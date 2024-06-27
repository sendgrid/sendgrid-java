/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Statistics API
 * The Marketing Campaigns Stats API allows you to retrieve statistics for both Automations and Single Sends. The statistics provided include bounces, clicks, opens, and more. You can export stats in CSV format for use in other applications. You can also retrieve Marketing Campaigns stats in the [Marketing Campaigns application user interface](https://mc.sendgrid.com/).  This API provides statistics for Marketing Campaigns only. For stats related to event tracking, please see the [Stats API](https://docs.sendgrid.com/api-reference/stats).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.mcstats.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.mcstats.models.Metrics;
import java.util.StringJoiner;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AutomationsResponseResultsInner {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private UUID id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("aggregation")
    @Getter
    @Setter
    private String aggregation;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("step_id")
    @Getter
    @Setter
    private String stepId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("stats")
    @Getter
    @Setter
    private Metrics stats;

    public AutomationsResponseResultsInner() {}

    private AutomationsResponseResultsInner(Builder builder) {
        this.id = builder.id;
        this.aggregation = builder.aggregation;
        this.stepId = builder.stepId;
        this.stats = builder.stats;
    }

    // Builder class for constructing object
    public static class Builder {

        private UUID id;
        private String aggregation;
        private String stepId;
        private Metrics stats;

        public Builder(UUID id, String aggregation, String stepId) {
            this.id = id;
            this.aggregation = aggregation;
            this.stepId = stepId;
        }

        public Builder stats(Metrics stats) {
            this.stats = stats;
            return this;
        }

        public AutomationsResponseResultsInner build() {
            return new AutomationsResponseResultsInner(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            AutomationsResponseResultsInner.class.getSimpleName() + "(",
            ")"
        );
        if (id != null) joiner.add("id=" + id);
        if (aggregation != null) joiner.add("aggregation=" + aggregation);
        if (stepId != null) joiner.add("stepId=" + stepId);
        if (stats != null) joiner.add("stats=" + stats);
        return joiner.toString();
    }
}