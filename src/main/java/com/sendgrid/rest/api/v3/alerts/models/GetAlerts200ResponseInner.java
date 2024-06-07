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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class GetAlerts200ResponseInner {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("createdAt")
    @Getter
    @Setter
    private Integer createdAt;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("emailTo")
    @Getter
    @Setter
    private String emailTo;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("percentage")
    @Getter
    @Setter
    private Integer percentage;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("type")
    @Getter
    @Setter
    private Type1 type;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("updatedAt")
    @Getter
    @Setter
    private Integer updatedAt;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("frequency")
    @Getter
    @Setter
    private String frequency;

    public GetAlerts200ResponseInner() {
    }

    private GetAlerts200ResponseInner(Builder builder) {
        this.createdAt = builder.createdAt;
        this.emailTo = builder.emailTo;
        this.id = builder.id;
        this.percentage = builder.percentage;
        this.type = builder.type;
        this.updatedAt = builder.updatedAt;
        this.frequency = builder.frequency;
    }

    // Builder class for constructing object
    public static class Builder {
        private Integer createdAt;
        private String emailTo;
        private Integer id;
        private Integer percentage;
        private Type1 type;
        private Integer updatedAt;
        private String frequency;

        public Builder(Integer createdAt, String emailTo, Integer id, Type1 type) {
            this.createdAt = createdAt;
            this.emailTo = emailTo;
            this.id = id;
            this.type = type;
        }

        public Builder percentage(Integer percentage) {
            this.percentage = percentage;
            return this;
        }

        public Builder updatedAt(Integer updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder frequency(String frequency) {
            this.frequency = frequency;
            return this;
        }

        public GetAlerts200ResponseInner build() {
            return new GetAlerts200ResponseInner(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", GetAlerts200ResponseInner.class.getSimpleName() + "(", ")");
        if (createdAt != null) joiner.add("createdAt=" + createdAt);
        if (emailTo != null) joiner.add("emailTo=" + emailTo);
        if (id != null) joiner.add("id=" + id);
        if (percentage != null) joiner.add("percentage=" + percentage);
        if (type != null) joiner.add("type=" + type);
        if (updatedAt != null) joiner.add("updatedAt=" + updatedAt);
        if (frequency != null) joiner.add("frequency=" + frequency);
        return joiner.toString();
    }

}
         
    
