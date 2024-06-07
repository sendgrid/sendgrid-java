/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Link Branding API
 * The Twilio SendGrid Link Branding API allows you to configure your domain settings so that all of the click-tracked links, opens, and images in your emails are served from your domain rather than `sendgrid.net`. Spam filters and recipient servers look at the links within emails to determine whether the email appear trustworthy. They use the reputation of the root domain to determine whether the links can be trusted.  You can also manage Link Branding in the **Sender Authentication** section of the Twilio SendGrid application user interface.   See [**How to Set Up Link Branding**](https: //sendgrid.com/docs/ui/account-and-settings/how-to-set-up-link-branding/) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.linkbranding.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Valid1 {

    TRUE("true"),

    FALSE("false");

    private final String value;

    private Valid1(final String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    @JsonCreator
    public static Valid1 fromString(final String value) {
        return CustomDeserializer. enum (value, Valid1.values());
    }

}
