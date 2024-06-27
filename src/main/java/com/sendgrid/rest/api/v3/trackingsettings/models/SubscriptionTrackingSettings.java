/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Tracking Settings API
 * The Twilio SendGrid Tracking Settings API allows you to configure which tracking settings are enabled for your messages. You can track many of your recipients' interactions with your emails, including which emails they open, which links they click, and when they subscribe to or unsubscribe from your emails. See [**Tracking Settings**](https://docs.sendgrid.com/ui/account-and-settings/tracking) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.trackingsettings.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SubscriptionTrackingSettings {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("enabled")
    @Getter
    @Setter
    private Boolean enabled;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("html_content")
    @Getter
    @Setter
    private String htmlContent;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("landing")
    @Getter
    @Setter
    private String landing;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("plain_content")
    @Getter
    @Setter
    private String plainContent;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("replace")
    @Getter
    @Setter
    private String replace;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("url")
    @Getter
    @Setter
    private URI url;

    public SubscriptionTrackingSettings() {}

    private SubscriptionTrackingSettings(Builder builder) {
        this.enabled = builder.enabled;
        this.htmlContent = builder.htmlContent;
        this.landing = builder.landing;
        this.plainContent = builder.plainContent;
        this.replace = builder.replace;
        this.url = builder.url;
    }

    // Builder class for constructing object
    public static class Builder {

        private Boolean enabled;
        private String htmlContent;
        private String landing;
        private String plainContent;
        private String replace;
        private URI url;

        public Builder() {}

        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder htmlContent(String htmlContent) {
            this.htmlContent = htmlContent;
            return this;
        }

        public Builder landing(String landing) {
            this.landing = landing;
            return this;
        }

        public Builder plainContent(String plainContent) {
            this.plainContent = plainContent;
            return this;
        }

        public Builder replace(String replace) {
            this.replace = replace;
            return this;
        }

        public Builder url(URI url) {
            this.url = url;
            return this;
        }

        public SubscriptionTrackingSettings build() {
            return new SubscriptionTrackingSettings(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            SubscriptionTrackingSettings.class.getSimpleName() + "(",
            ")"
        );
        if (enabled != null) joiner.add("enabled=" + enabled);
        if (htmlContent != null) joiner.add("htmlContent=" + htmlContent);
        if (landing != null) joiner.add("landing=" + landing);
        if (plainContent != null) joiner.add("plainContent=" + plainContent);
        if (replace != null) joiner.add("replace=" + replace);
        if (url != null) joiner.add("url=" + url);
        return joiner.toString();
    }
}