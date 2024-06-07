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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;


@ToString
public class AutmoationsLinkStatsResponse {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("results")
    @Getter
    @Setter
    private List<AutmoationsLinkStatsResponseResultsInner> results;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("totalClicks")
    @Getter
    @Setter
    private Integer totalClicks;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("metadata")
    @Getter
    @Setter
    private LinkTrackingMetadata metadata;

    public AutmoationsLinkStatsResponse() {
    }

    private AutmoationsLinkStatsResponse(Builder builder) {
        this.results = builder.results;
        this.totalClicks = builder.totalClicks;
        this.metadata = builder.metadata;
    }

    // Builder class for constructing object
    public static class Builder {
        private List<AutmoationsLinkStatsResponseResultsInner> results;
        private Integer totalClicks;
        private LinkTrackingMetadata metadata;

        public Builder(List<AutmoationsLinkStatsResponseResultsInner> results, Integer totalClicks, LinkTrackingMetadata metadata) {
            this.results = results;
            this.totalClicks = totalClicks;
            this.metadata = metadata;
        }

        public AutmoationsLinkStatsResponse build() {
            return new AutmoationsLinkStatsResponse(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", AutmoationsLinkStatsResponse.class.getSimpleName() + "(", ")");
        if (results != null) joiner.add("results=" + results);
        if (totalClicks != null) joiner.add("totalClicks=" + totalClicks);
        if (metadata != null) joiner.add("metadata=" + metadata);
        return joiner.toString();
    }

}
         
    
