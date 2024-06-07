/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Subusers
 * The Twilio SendGrid Subusers API allows you to create and manage your Subuser accounts. Subusers are available on [Pro and Premier plans](https://sendgrid.com/pricing), and you can think of them as sub-accounts. Each Subuser can have its own sending domains, IP addresses, and reporting. SendGrid recommends creating Subusers for each of the different types of emails you send—one Subuser for transactional emails and another for marketing emails. Independent Software Vendor (ISV) customers may also create Subusers for each of their customers.  You can also manage Subusers in the [Twilio SendGrid application user interface](https://app.sendgrid.com/settings/subusers). See [**Subusers**](https://docs.sendgrid.com/ui/account-and-settings/subusers) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.subusers.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Region2 {

    GLOBAL("global"),

    EU("eu");

    private final String value;

    private Region2(final String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    @JsonCreator
    public static Region2 fromString(final String value) {
        return CustomDeserializer. enum (value, Region2.values());
    }

}
