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
import com.sendgrid.rest.api.v3.mccontacts.models.ContactDetails3;
import com.sendgrid.rest.api.v3.mccontacts.models.SelfMetadata;
import java.math.BigDecimal;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SearchContact200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("result")
    @Getter
    @Setter
    private List<ContactDetails3> result;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("_metadata")
    @Getter
    @Setter
    private SelfMetadata metadata;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("contact_count")
    @Getter
    @Setter
    private BigDecimal contactCount;

    public SearchContact200Response() {}

    private SearchContact200Response(Builder builder) {
        this.result = builder.result;
        this.metadata = builder.metadata;
        this.contactCount = builder.contactCount;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<ContactDetails3> result;
        private SelfMetadata metadata;
        private BigDecimal contactCount;

        public Builder(BigDecimal contactCount) {
            this.contactCount = contactCount;
        }

        public Builder result(List<ContactDetails3> result) {
            this.result = result;
            return this;
        }

        public Builder metadata(SelfMetadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public SearchContact200Response build() {
            return new SearchContact200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            SearchContact200Response.class.getSimpleName() + "(",
            ")"
        );
        if (result != null) joiner.add("result=" + result);
        if (metadata != null) joiner.add("metadata=" + metadata);
        if (contactCount != null) joiner.add("contactCount=" + contactCount);
        return joiner.toString();
    }
}