/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Statistics API
 * The Twilio SendGrid Statistics API allows you to retrieve the various statistics related to your email program.  Tracking your emails is an important part of being a good sender and learning about how your users interact with your email. This includes everything from clicks and opens to looking at which browsers and mailbox providers your customers use.  SendGrid has broken up statistics in specific ways so that you can get at-a-glance data, as well as the details of how your email is being used.  Category statistics are available for the previous thirteen months only.  See [**Statistics Overview**](https://docs.sendgrid.com/ui/analytics-and-reporting/stats-overview) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.stats.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;


@ToString
public class GetStats200ResponseInner {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("date")
    @Getter
    @Setter
    private String date;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("stats")
    @Getter
    @Setter
    private List<GetStats200ResponseInnerStatsInner> stats;

    public GetStats200ResponseInner() {
    }

    private GetStats200ResponseInner(Builder builder) {
        this.date = builder.date;
        this.stats = builder.stats;
    }

    // Builder class for constructing object
    public static class Builder {
        private String date;
        private List<GetStats200ResponseInnerStatsInner> stats;

        public Builder(String date, List<GetStats200ResponseInnerStatsInner> stats) {
            this.date = date;
            this.stats = stats;
        }

        public GetStats200ResponseInner build() {
            return new GetStats200ResponseInner(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", GetStats200ResponseInner.class.getSimpleName() + "(", ")");
        if (date != null) joiner.add("date=" + date);
        if (stats != null) joiner.add("stats=" + stats);
        return joiner.toString();
    }

}
         
    
