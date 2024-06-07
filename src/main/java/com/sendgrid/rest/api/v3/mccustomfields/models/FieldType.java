/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Custom Fields API
 * The Twilio SendGrid Marketing Campaigns Custom Fields API allows you to add extra information about your marketing contacts that is relevant to your needs. For example, a fashion retailer might create a custom field for customers' shoe sizes, an ice cream shop might store customers' favorite flavors in a custom field, and you can create custom fields that make sense for your business.  With custom fields, you can also create [segments](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2/) based on custom fields values. Your custom fields are completely customizable to the use-cases and user information that you need.  You can also manage your Custom Fields using the SendGrid application user interface. See [**Using Custom Fields**](https://docs.sendgrid.com/ui/managing-contacts/custom-fields) for more information, including a list of Reserved Fields. You can also manage your custom fields in the [Marketing Campaigns application user interface](https://mc.sendgrid.com/custom-fields).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mccustomfields.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FieldType {

    TEXT("Text"),

    NUMBER("Number"),

    DATE("Date");

    private final String value;

    private FieldType(final String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    @JsonCreator
    public static FieldType fromString(final String value) {
        return CustomDeserializer. enum (value, FieldType.values());
    }

}
