/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Mail Settings API
 * The Twilio SendGrid Mail Settings API allows you to retrieve and configure the various Mail Settings available. Mail Settings instruct SendGrid to apply specific settings to every email that you send over [SendGrid’s Web API](https://docs.sendgrid.com/api-reference/mail-send/v3-mail-send) or [SMTP relay](https://sendgrid.com/docs/for-developers/sending-email/building-an-x-smtpapi-header/). These settings include how to embed a custom footer, how to manage blocks, spam, and bounces, and more.  For a full list of Twilio SendGrid's Mail Settings, and what each one does, see [**Mail Settings**](https://sendgrid.com/docs/ui/account-and-settings/mail/).  You can also manage your Mail Settings in the Twilio SendGrid application user interface.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mailsettings.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class MailSettingsForwardBounce {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("email")
    @Getter
    @Setter
    private String email;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("enabled")
    @Getter
    @Setter
    private Boolean enabled;

    public MailSettingsForwardBounce() {
    }

    private MailSettingsForwardBounce(Builder builder) {
        this.email = builder.email;
        this.enabled = builder.enabled;
    }

    // Builder class for constructing object
    public static class Builder {
        private String email;
        private Boolean enabled;

        public Builder() {
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public MailSettingsForwardBounce build() {
            return new MailSettingsForwardBounce(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", MailSettingsForwardBounce.class.getSimpleName() + "(", ")");
        if (email != null) joiner.add("email=" + email);
        if (enabled != null) joiner.add("enabled=" + enabled);
        return joiner.toString();
    }

}
         
    
