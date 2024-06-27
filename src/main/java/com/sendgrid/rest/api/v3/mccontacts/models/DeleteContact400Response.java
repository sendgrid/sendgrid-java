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
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DeleteContact400Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("errors")
    @Getter
    @Setter
    private List<Object> errors;

    public DeleteContact400Response() {}

    private DeleteContact400Response(Builder builder) {
        this.errors = builder.errors;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<Object> errors;

        public Builder(List<Object> errors) {
            this.errors = errors;
        }

        public DeleteContact400Response build() {
            return new DeleteContact400Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            DeleteContact400Response.class.getSimpleName() + "(",
            ")"
        );
        if (errors != null) joiner.add("errors=" + errors);
        return joiner.toString();
    }
}
