/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Subusers
 * The Twilio SendGrid Subusers API allows you to create and manage your Subuser accounts. Subusers are available on [Pro and Premier plans](https://sendgrid.com/pricing), and you can think of them as sub-accounts. Each Subuser can have its own sending domains, IP addresses, and reporting. SendGrid recommends creating Subusers for each of the different types of emails you send—one Subuser for transactional emails and another for marketing emails. Independent Software Vendor (ISV) customers may also create Subusers for each of their customers.  You can also manage Subusers in the [Twilio SendGrid application user interface](https://app.sendgrid.com/settings/subusers). See [**Subusers**](https://docs.sendgrid.com/ui/account-and-settings/subusers) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.subusers.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.subusers.models.SubuserStatsStatsInner;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SubuserStats {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("date")
    @Getter
    @Setter
    private String date;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("stats")
    @Getter
    @Setter
    private List<SubuserStatsStatsInner> stats;

    public SubuserStats() {}

    private SubuserStats(Builder builder) {
        this.date = builder.date;
        this.stats = builder.stats;
    }

    // Builder class for constructing object
    public static class Builder {

        private String date;
        private List<SubuserStatsStatsInner> stats;

        public Builder() {}

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public Builder stats(List<SubuserStatsStatsInner> stats) {
            this.stats = stats;
            return this;
        }

        public SubuserStats build() {
            return new SubuserStats(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            SubuserStats.class.getSimpleName() + "(",
            ")"
        );
        if (date != null) joiner.add("date=" + date);
        if (stats != null) joiner.add("stats=" + stats);
        return joiner.toString();
    }
}
