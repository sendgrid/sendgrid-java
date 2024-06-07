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
public class PatchMailSettingsTemplateRequest {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("enabled")
    @Getter
    @Setter
    private Boolean enabled;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("htmlContent")
    @Getter
    @Setter
    private String htmlContent;

    public PatchMailSettingsTemplateRequest() {
    }

    private PatchMailSettingsTemplateRequest(Builder builder) {
        this.enabled = builder.enabled;
        this.htmlContent = builder.htmlContent;
    }

    // Builder class for constructing object
    public static class Builder {
        private Boolean enabled;
        private String htmlContent;

        public Builder() {
        }

        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder htmlContent(String htmlContent) {
            this.htmlContent = htmlContent;
            return this;
        }

        public PatchMailSettingsTemplateRequest build() {
            return new PatchMailSettingsTemplateRequest(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", PatchMailSettingsTemplateRequest.class.getSimpleName() + "(", ")");
        if (enabled != null) joiner.add("enabled=" + enabled);
        if (htmlContent != null) joiner.add("htmlContent=" + htmlContent);
        return joiner.toString();
    }

}
         
    
