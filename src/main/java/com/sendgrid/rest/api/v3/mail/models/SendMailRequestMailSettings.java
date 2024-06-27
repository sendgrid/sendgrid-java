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
import com.sendgrid.rest.api.v3.mail.models.SendMailRequestMailSettingsBypassBounceManagement;
import com.sendgrid.rest.api.v3.mail.models.SendMailRequestMailSettingsBypassListManagement;
import com.sendgrid.rest.api.v3.mail.models.SendMailRequestMailSettingsBypassSpamManagement;
import com.sendgrid.rest.api.v3.mail.models.SendMailRequestMailSettingsBypassUnsubscribeManagement;
import com.sendgrid.rest.api.v3.mail.models.SendMailRequestMailSettingsFooter;
import com.sendgrid.rest.api.v3.mail.models.SendMailRequestMailSettingsSandboxMode;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SendMailRequestMailSettings {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("bypass_list_management")
    @Getter
    @Setter
    private SendMailRequestMailSettingsBypassListManagement bypassListManagement;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("bypass_spam_management")
    @Getter
    @Setter
    private SendMailRequestMailSettingsBypassSpamManagement bypassSpamManagement;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("bypass_bounce_management")
    @Getter
    @Setter
    private SendMailRequestMailSettingsBypassBounceManagement bypassBounceManagement;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("bypass_unsubscribe_management")
    @Getter
    @Setter
    private SendMailRequestMailSettingsBypassUnsubscribeManagement bypassUnsubscribeManagement;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("footer")
    @Getter
    @Setter
    private SendMailRequestMailSettingsFooter footer;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("sandbox_mode")
    @Getter
    @Setter
    private SendMailRequestMailSettingsSandboxMode sandboxMode;

    public SendMailRequestMailSettings() {}

    private SendMailRequestMailSettings(Builder builder) {
        this.bypassListManagement = builder.bypassListManagement;
        this.bypassSpamManagement = builder.bypassSpamManagement;
        this.bypassBounceManagement = builder.bypassBounceManagement;
        this.bypassUnsubscribeManagement = builder.bypassUnsubscribeManagement;
        this.footer = builder.footer;
        this.sandboxMode = builder.sandboxMode;
    }

    // Builder class for constructing object
    public static class Builder {

        private SendMailRequestMailSettingsBypassListManagement bypassListManagement;
        private SendMailRequestMailSettingsBypassSpamManagement bypassSpamManagement;
        private SendMailRequestMailSettingsBypassBounceManagement bypassBounceManagement;
        private SendMailRequestMailSettingsBypassUnsubscribeManagement bypassUnsubscribeManagement;
        private SendMailRequestMailSettingsFooter footer;
        private SendMailRequestMailSettingsSandboxMode sandboxMode;

        public Builder() {}

        public Builder bypassListManagement(
            SendMailRequestMailSettingsBypassListManagement bypassListManagement
        ) {
            this.bypassListManagement = bypassListManagement;
            return this;
        }

        public Builder bypassSpamManagement(
            SendMailRequestMailSettingsBypassSpamManagement bypassSpamManagement
        ) {
            this.bypassSpamManagement = bypassSpamManagement;
            return this;
        }

        public Builder bypassBounceManagement(
            SendMailRequestMailSettingsBypassBounceManagement bypassBounceManagement
        ) {
            this.bypassBounceManagement = bypassBounceManagement;
            return this;
        }

        public Builder bypassUnsubscribeManagement(
            SendMailRequestMailSettingsBypassUnsubscribeManagement bypassUnsubscribeManagement
        ) {
            this.bypassUnsubscribeManagement = bypassUnsubscribeManagement;
            return this;
        }

        public Builder footer(SendMailRequestMailSettingsFooter footer) {
            this.footer = footer;
            return this;
        }

        public Builder sandboxMode(
            SendMailRequestMailSettingsSandboxMode sandboxMode
        ) {
            this.sandboxMode = sandboxMode;
            return this;
        }

        public SendMailRequestMailSettings build() {
            return new SendMailRequestMailSettings(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            SendMailRequestMailSettings.class.getSimpleName() + "(",
            ")"
        );
        if (bypassListManagement != null) joiner.add(
            "bypassListManagement=" + bypassListManagement
        );
        if (bypassSpamManagement != null) joiner.add(
            "bypassSpamManagement=" + bypassSpamManagement
        );
        if (bypassBounceManagement != null) joiner.add(
            "bypassBounceManagement=" + bypassBounceManagement
        );
        if (bypassUnsubscribeManagement != null) joiner.add(
            "bypassUnsubscribeManagement=" + bypassUnsubscribeManagement
        );
        if (footer != null) joiner.add("footer=" + footer);
        if (sandboxMode != null) joiner.add("sandboxMode=" + sandboxMode);
        return joiner.toString();
    }
}