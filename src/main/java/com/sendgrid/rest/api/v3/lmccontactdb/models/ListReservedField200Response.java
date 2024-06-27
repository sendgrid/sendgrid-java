/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Legacy Marketing Campaigns Contacts API
 * The Twilio SendGrid Legacy Marketing Campaigns Contacts API allows you to manage your marketing contacts programmatically. This API is operational, but we recommend using the current version of Marketing Campaigns' [Contacts API](https://docs.sendgrid.com/api-reference/contacts/), [Lists API](https://docs.sendgrid.com/api-reference/lists/), and [Segments API](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2/) to manage your contacts.  See [**Migrating from Legacy Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/migrating-from-legacy-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.lmccontactdb.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.lmccontactdb.models.ListReservedField200ResponseReservedFieldsInner;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListReservedField200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("reserved_fields")
    @Getter
    @Setter
    private List<
        ListReservedField200ResponseReservedFieldsInner
    > reservedFields;

    public ListReservedField200Response() {}

    private ListReservedField200Response(Builder builder) {
        this.reservedFields = builder.reservedFields;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<
            ListReservedField200ResponseReservedFieldsInner
        > reservedFields;

        public Builder() {}

        public Builder reservedFields(
            List<ListReservedField200ResponseReservedFieldsInner> reservedFields
        ) {
            this.reservedFields = reservedFields;
            return this;
        }

        public ListReservedField200Response build() {
            return new ListReservedField200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListReservedField200Response.class.getSimpleName() + "(",
            ")"
        );
        if (reservedFields != null) joiner.add(
            "reservedFields=" + reservedFields
        );
        return joiner.toString();
    }
}