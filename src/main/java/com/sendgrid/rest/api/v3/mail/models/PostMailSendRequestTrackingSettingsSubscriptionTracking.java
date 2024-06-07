/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Mail API
 * The Twilio SendGrid v3 Mail API allows you to send email at scale over HTTP. The Mail Send endpoint supports many levels of functionality, allowing you to send templates, set categories and custom arguments that can be used to analyze your send, and configure which tracking settings to include such as opens and clicks. You can also group mail sends into batches, allowing you to schedule and cancel sends by their batch IDs.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mail.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class PostMailSendRequestTrackingSettingsSubscriptionTracking {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("enable")
    @Getter
    @Setter
    private Boolean enable;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("text")
    @Getter
    @Setter
    private String text;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("html")
    @Getter
    @Setter
    private String html;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("substitutionTag")
    @Getter
    @Setter
    private String substitutionTag;

    public PostMailSendRequestTrackingSettingsSubscriptionTracking() {
    }

    private PostMailSendRequestTrackingSettingsSubscriptionTracking(Builder builder) {
        this.enable = builder.enable;
        this.text = builder.text;
        this.html = builder.html;
        this.substitutionTag = builder.substitutionTag;
    }

    // Builder class for constructing object
    public static class Builder {
        private Boolean enable;
        private String text;
        private String html;
        private String substitutionTag;

        public Builder() {
        }

        public Builder enable(Boolean enable) {
            this.enable = enable;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder html(String html) {
            this.html = html;
            return this;
        }

        public Builder substitutionTag(String substitutionTag) {
            this.substitutionTag = substitutionTag;
            return this;
        }

        public PostMailSendRequestTrackingSettingsSubscriptionTracking build() {
            return new PostMailSendRequestTrackingSettingsSubscriptionTracking(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", PostMailSendRequestTrackingSettingsSubscriptionTracking.class.getSimpleName() + "(", ")");
        if (enable != null) joiner.add("enable=" + enable);
        if (text != null) joiner.add("text=" + text);
        if (html != null) joiner.add("html=" + html);
        if (substitutionTag != null) joiner.add("substitutionTag=" + substitutionTag);
        return joiner.toString();
    }

}
         
    
