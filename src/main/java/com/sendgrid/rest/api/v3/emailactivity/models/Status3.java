/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Email Activity API
 * The Twilio SendGrid Email Activity API allows you to query all of your stored messages, query individual messages, and download a CSV with data about the stored messages. Once retrieved, you can inspect the data associated with your messages to better understand your mail send. For example, you may retrieve all bounced messages or all messages with the same subject line and search for commonalities among them.  You must [purchase additional email activity history](https://app.sendgrid.com/settings/billing/addons/email_activity) to gain access to the Email Activity Feed API.  See **Getting Started with the Email Activity Feed API** for help building queries and working with this API. You can also work with email activity in the **Activity** section of the [Twilio SendGrid application user interface](https://app.sendgrid.com/email_activity).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.emailactivity.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sendgrid.converter.Promoter;

public enum Status3 {
    PROCESSED("processed"),

    DELIVERED("delivered"),

    NOT_DELIVERED("not_delivered");

    private final String value;

    private Status3(final String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }

    @JsonCreator
    public static Status3 forValue(final String value) {
        return Promoter.enumFromString(value, Status3.values());
    }
}
