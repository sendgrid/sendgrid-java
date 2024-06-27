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
import com.sendgrid.rest.api.v3.lmccontactdb.models.ContactdbSegments;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListAllSegmentsResponse {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("segments")
    @Getter
    @Setter
    private List<ContactdbSegments> segments;

    public ListAllSegmentsResponse() {}

    private ListAllSegmentsResponse(Builder builder) {
        this.segments = builder.segments;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<ContactdbSegments> segments;

        public Builder(List<ContactdbSegments> segments) {
            this.segments = segments;
        }

        public ListAllSegmentsResponse build() {
            return new ListAllSegmentsResponse(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListAllSegmentsResponse.class.getSimpleName() + "(",
            ")"
        );
        if (segments != null) joiner.add("segments=" + segments);
        return joiner.toString();
    }
}