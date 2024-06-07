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
public class ClickTracking {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("enableText")
    @Getter
    @Setter
    private Boolean enableText;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("enabled")
    @Getter
    @Setter
    private Boolean enabled;

    public ClickTracking() {
    }

    private ClickTracking(Builder builder) {
        this.enableText = builder.enableText;
        this.enabled = builder.enabled;
    }

    // Builder class for constructing object
    public static class Builder {
        private Boolean enableText;
        private Boolean enabled;

        public Builder(Boolean enableText, Boolean enabled) {
            this.enableText = enableText;
            this.enabled = enabled;
        }

        public ClickTracking build() {
            return new ClickTracking(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", ClickTracking.class.getSimpleName() + "(", ")");
        if (enableText != null) joiner.add("enableText=" + enableText);
        if (enabled != null) joiner.add("enabled=" + enabled);
        return joiner.toString();
    }

}
         
    
