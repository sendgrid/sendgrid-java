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
import com.sendgrid.rest.api.v3.lmccontactdb.models.ContactdbSegmentsConditions;
import java.math.BigDecimal;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UpdateSegmentRequest {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("list_id")
    @Getter
    @Setter
    private BigDecimal listId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("conditions")
    @Getter
    @Setter
    private List<ContactdbSegmentsConditions> conditions;

    public UpdateSegmentRequest() {}

    private UpdateSegmentRequest(Builder builder) {
        this.name = builder.name;
        this.listId = builder.listId;
        this.conditions = builder.conditions;
    }

    // Builder class for constructing object
    public static class Builder {

        private String name;
        private BigDecimal listId;
        private List<ContactdbSegmentsConditions> conditions;

        public Builder(String name) {
            this.name = name;
        }

        public Builder listId(BigDecimal listId) {
            this.listId = listId;
            return this;
        }

        public Builder conditions(
            List<ContactdbSegmentsConditions> conditions
        ) {
            this.conditions = conditions;
            return this;
        }

        public UpdateSegmentRequest build() {
            return new UpdateSegmentRequest(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            UpdateSegmentRequest.class.getSimpleName() + "(",
            ")"
        );
        if (name != null) joiner.add("name=" + name);
        if (listId != null) joiner.add("listId=" + listId);
        if (conditions != null) joiner.add("conditions=" + conditions);
        return joiner.toString();
    }
}