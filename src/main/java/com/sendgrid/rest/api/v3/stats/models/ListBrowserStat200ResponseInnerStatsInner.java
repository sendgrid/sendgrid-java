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
import com.sendgrid.rest.api.v3.stats.models.AdvancedStatsClicks;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListBrowserStat200ResponseInnerStatsInner {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("type")
    @Getter
    @Setter
    private String type;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("metrics")
    @Getter
    @Setter
    private AdvancedStatsClicks metrics;

    public ListBrowserStat200ResponseInnerStatsInner() {}

    private ListBrowserStat200ResponseInnerStatsInner(Builder builder) {
        this.type = builder.type;
        this.name = builder.name;
        this.metrics = builder.metrics;
    }

    // Builder class for constructing object
    public static class Builder {

        private String type;
        private String name;
        private AdvancedStatsClicks metrics;

        public Builder() {}

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder metrics(AdvancedStatsClicks metrics) {
            this.metrics = metrics;
            return this;
        }

        public ListBrowserStat200ResponseInnerStatsInner build() {
            return new ListBrowserStat200ResponseInnerStatsInner(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListBrowserStat200ResponseInnerStatsInner.class.getSimpleName() +
            "(",
            ")"
        );
        if (type != null) joiner.add("type=" + type);
        if (name != null) joiner.add("name=" + name);
        if (metrics != null) joiner.add("metrics=" + metrics);
        return joiner.toString();
    }
}
