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

import java.net.URI;
import java.util.StringJoiner;
import java.util.UUID;


@ToString
public class AutmoationsLinkStatsResponseResultsInner {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("url")
    @Getter
    @Setter
    private URI url;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("urlLocation")
    @Getter
    @Setter
    private Integer urlLocation;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("stepId")
    @Getter
    @Setter
    private UUID stepId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("clicks")
    @Getter
    @Setter
    private Integer clicks;

    public AutmoationsLinkStatsResponseResultsInner() {
    }

    private AutmoationsLinkStatsResponseResultsInner(Builder builder) {
        this.url = builder.url;
        this.urlLocation = builder.urlLocation;
        this.stepId = builder.stepId;
        this.clicks = builder.clicks;
    }

    // Builder class for constructing object
    public static class Builder {
        private URI url;
        private Integer urlLocation;
        private UUID stepId;
        private Integer clicks;

        public Builder(URI url, UUID stepId, Integer clicks) {
            this.url = url;
            this.stepId = stepId;
            this.clicks = clicks;
        }

        public Builder urlLocation(Integer urlLocation) {
            this.urlLocation = urlLocation;
            return this;
        }

        public AutmoationsLinkStatsResponseResultsInner build() {
            return new AutmoationsLinkStatsResponseResultsInner(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", AutmoationsLinkStatsResponseResultsInner.class.getSimpleName() + "(", ")");
        if (url != null) joiner.add("url=" + url);
        if (urlLocation != null) joiner.add("urlLocation=" + urlLocation);
        if (stepId != null) joiner.add("stepId=" + stepId);
        if (clicks != null) joiner.add("clicks=" + clicks);
        return joiner.toString();
    }

}
         
    
