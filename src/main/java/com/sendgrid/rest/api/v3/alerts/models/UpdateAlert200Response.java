/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Alerts API
 * The Twilio SendGrid Alerts API allows you to specify an email address to receive notifications regarding your email usage or statistics. You can set up alerts to be sent to a specific email address on a recurring basis, whether for informational purposes or when specific account actions occur.  For most alerts, you can choose to have the alert sent to you as needed, hourly, daily, weekly, or monthly. The information contained in your alert will be for the last period of the alert. For example, if you choose weekly for the statistics alert, you will receive the statistics for the last week.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.alerts.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.alerts.models.Type3;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UpdateAlert200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("created_at")
    @Getter
    @Setter
    private Integer createdAt;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("email_to")
    @Getter
    @Setter
    private String emailTo;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("frequency")
    @Getter
    @Setter
    private String frequency;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("type")
    @Getter
    @Setter
    private Type3 type;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("updated_at")
    @Getter
    @Setter
    private Integer updatedAt;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("percentage")
    @Getter
    @Setter
    private Integer percentage;

    public UpdateAlert200Response() {}

    private UpdateAlert200Response(Builder builder) {
        this.createdAt = builder.createdAt;
        this.emailTo = builder.emailTo;
        this.frequency = builder.frequency;
        this.id = builder.id;
        this.type = builder.type;
        this.updatedAt = builder.updatedAt;
        this.percentage = builder.percentage;
    }

    // Builder class for constructing object
    public static class Builder {

        private Integer createdAt;
        private String emailTo;
        private String frequency;
        private Integer id;
        private Type3 type;
        private Integer updatedAt;
        private Integer percentage;

        public Builder(
            Integer createdAt,
            String emailTo,
            Integer id,
            Type3 type,
            Integer updatedAt
        ) {
            this.createdAt = createdAt;
            this.emailTo = emailTo;
            this.id = id;
            this.type = type;
            this.updatedAt = updatedAt;
        }

        public Builder frequency(String frequency) {
            this.frequency = frequency;
            return this;
        }

        public Builder percentage(Integer percentage) {
            this.percentage = percentage;
            return this;
        }

        public UpdateAlert200Response build() {
            return new UpdateAlert200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            UpdateAlert200Response.class.getSimpleName() + "(",
            ")"
        );
        if (createdAt != null) joiner.add("createdAt=" + createdAt);
        if (emailTo != null) joiner.add("emailTo=" + emailTo);
        if (frequency != null) joiner.add("frequency=" + frequency);
        if (id != null) joiner.add("id=" + id);
        if (type != null) joiner.add("type=" + type);
        if (updatedAt != null) joiner.add("updatedAt=" + updatedAt);
        if (percentage != null) joiner.add("percentage=" + percentage);
        return joiner.toString();
    }
}
