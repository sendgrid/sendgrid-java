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
import com.sendgrid.rest.api.v3.mcstats.models.AutomationsResponseResultsInner;
import com.sendgrid.rest.api.v3.mcstats.models.Metadata;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AutomationsResponse {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("results")
    @Getter
    @Setter
    private List<AutomationsResponseResultsInner> results;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("_metadata")
    @Getter
    @Setter
    private Metadata metadata;

    public AutomationsResponse() {}

    private AutomationsResponse(Builder builder) {
        this.results = builder.results;
        this.metadata = builder.metadata;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<AutomationsResponseResultsInner> results;
        private Metadata metadata;

        public Builder(List<AutomationsResponseResultsInner> results) {
            this.results = results;
        }

        public Builder metadata(Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public AutomationsResponse build() {
            return new AutomationsResponse(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            AutomationsResponse.class.getSimpleName() + "(",
            ")"
        );
        if (results != null) joiner.add("results=" + results);
        if (metadata != null) joiner.add("metadata=" + metadata);
        return joiner.toString();
    }
}