/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Contacts API
 * The Twilio SendGrid Marketing Campaigns Contacts API allows you to manage all of your marketing contacts programmatically. You can also import and export contacts using this API. The Contacts API allows you to associate contacts with lists and segments; however, to manage the lists and segments themselves, see the [Lists API](https://docs.sendgrid.com/api-reference/lists/) and [Segments API](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2/).  You can also manage your marketing contacts with the [Marketing Campaigns application user interface](https://mc.sendgrid.com/contacts). See [**How to Send Email with New Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/how-to-send-email-with-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mccontacts.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class ContactsError {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("message")
    @Getter
    @Setter
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("field")
    @Getter
    @Setter
    private String field;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("errorId")
    @Getter
    @Setter
    private String errorId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("parameter")
    @Getter
    @Setter
    private String parameter;

    public ContactsError() {
    }

    private ContactsError(Builder builder) {
        this.message = builder.message;
        this.field = builder.field;
        this.errorId = builder.errorId;
        this.parameter = builder.parameter;
    }

    // Builder class for constructing object
    public static class Builder {
        private String message;
        private String field;
        private String errorId;
        private String parameter;

        public Builder(String message) {
            this.message = message;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder errorId(String errorId) {
            this.errorId = errorId;
            return this;
        }

        public Builder parameter(String parameter) {
            this.parameter = parameter;
            return this;
        }

        public ContactsError build() {
            return new ContactsError(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", ContactsError.class.getSimpleName() + "(", ")");
        if (message != null) joiner.add("message=" + message);
        if (field != null) joiner.add("field=" + field);
        if (errorId != null) joiner.add("errorId=" + errorId);
        if (parameter != null) joiner.add("parameter=" + parameter);
        return joiner.toString();
    }

}
         
    
