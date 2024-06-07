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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class GoogleAnalyticsSettings {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("enabled")
    @Getter
    @Setter
    private Boolean enabled;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("utmCampaign")
    @Getter
    @Setter
    private String utmCampaign;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("utmContent")
    @Getter
    @Setter
    private String utmContent;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("utmMedium")
    @Getter
    @Setter
    private String utmMedium;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("utmSource")
    @Getter
    @Setter
    private String utmSource;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("utmTerm")
    @Getter
    @Setter
    private String utmTerm;

    public GoogleAnalyticsSettings() {
    }

    private GoogleAnalyticsSettings(Builder builder) {
        this.enabled = builder.enabled;
        this.utmCampaign = builder.utmCampaign;
        this.utmContent = builder.utmContent;
        this.utmMedium = builder.utmMedium;
        this.utmSource = builder.utmSource;
        this.utmTerm = builder.utmTerm;
    }

    // Builder class for constructing object
    public static class Builder {
        private Boolean enabled;
        private String utmCampaign;
        private String utmContent;
        private String utmMedium;
        private String utmSource;
        private String utmTerm;

        public Builder() {
        }

        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder utmCampaign(String utmCampaign) {
            this.utmCampaign = utmCampaign;
            return this;
        }

        public Builder utmContent(String utmContent) {
            this.utmContent = utmContent;
            return this;
        }

        public Builder utmMedium(String utmMedium) {
            this.utmMedium = utmMedium;
            return this;
        }

        public Builder utmSource(String utmSource) {
            this.utmSource = utmSource;
            return this;
        }

        public Builder utmTerm(String utmTerm) {
            this.utmTerm = utmTerm;
            return this;
        }

        public GoogleAnalyticsSettings build() {
            return new GoogleAnalyticsSettings(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", GoogleAnalyticsSettings.class.getSimpleName() + "(", ")");
        if (enabled != null) joiner.add("enabled=" + enabled);
        if (utmCampaign != null) joiner.add("utmCampaign=" + utmCampaign);
        if (utmContent != null) joiner.add("utmContent=" + utmContent);
        if (utmMedium != null) joiner.add("utmMedium=" + utmMedium);
        if (utmSource != null) joiner.add("utmSource=" + utmSource);
        if (utmTerm != null) joiner.add("utmTerm=" + utmTerm);
        return joiner.toString();
    }

}
         
    
