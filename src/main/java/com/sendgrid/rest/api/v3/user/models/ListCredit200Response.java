/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid User API
 * The Twilio SendGrid User API allows you to modify the settings of a SendGrid user account such as the user's email address or username. Keeping your user profile up to date helps SendGrid verify who you are and share important communications with you.  See [**Account Details**](https://docs.sendgrid.com/ui/account-and-settings/account) for more information. You can also manage your user settings in the [SendGrid application user interface](https://app.sendgrid.com/account/details).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.user.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListCredit200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("remain")
    @Getter
    @Setter
    private Integer remain;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("total")
    @Getter
    @Setter
    private Integer total;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("overage")
    @Getter
    @Setter
    private Integer overage;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("used")
    @Getter
    @Setter
    private Integer used;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("last_reset")
    @Getter
    @Setter
    private String lastReset;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("next_reset")
    @Getter
    @Setter
    private String nextReset;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("reset_frequency")
    @Getter
    @Setter
    private String resetFrequency;

    public ListCredit200Response() {}

    private ListCredit200Response(Builder builder) {
        this.remain = builder.remain;
        this.total = builder.total;
        this.overage = builder.overage;
        this.used = builder.used;
        this.lastReset = builder.lastReset;
        this.nextReset = builder.nextReset;
        this.resetFrequency = builder.resetFrequency;
    }

    // Builder class for constructing object
    public static class Builder {

        private Integer remain;
        private Integer total;
        private Integer overage;
        private Integer used;
        private String lastReset;
        private String nextReset;
        private String resetFrequency;

        public Builder(
            Integer remain,
            Integer total,
            Integer overage,
            Integer used,
            String lastReset,
            String nextReset,
            String resetFrequency
        ) {
            this.remain = remain;
            this.total = total;
            this.overage = overage;
            this.used = used;
            this.lastReset = lastReset;
            this.nextReset = nextReset;
            this.resetFrequency = resetFrequency;
        }

        public ListCredit200Response build() {
            return new ListCredit200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListCredit200Response.class.getSimpleName() + "(",
            ")"
        );
        if (remain != null) joiner.add("remain=" + remain);
        if (total != null) joiner.add("total=" + total);
        if (overage != null) joiner.add("overage=" + overage);
        if (used != null) joiner.add("used=" + used);
        if (lastReset != null) joiner.add("lastReset=" + lastReset);
        if (nextReset != null) joiner.add("nextReset=" + nextReset);
        if (resetFrequency != null) joiner.add(
            "resetFrequency=" + resetFrequency
        );
        return joiner.toString();
    }
}
