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
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ImportContact200ResponseUploadHeadersInner {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("header")
    @Getter
    @Setter
    private String header;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("value")
    @Getter
    @Setter
    private String value;

    public ImportContact200ResponseUploadHeadersInner() {}

    private ImportContact200ResponseUploadHeadersInner(Builder builder) {
        this.header = builder.header;
        this.value = builder.value;
    }

    // Builder class for constructing object
    public static class Builder {

        private String header;
        private String value;

        public Builder(String header, String value) {
            this.header = header;
            this.value = value;
        }

        public ImportContact200ResponseUploadHeadersInner build() {
            return new ImportContact200ResponseUploadHeadersInner(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ImportContact200ResponseUploadHeadersInner.class.getSimpleName() +
            "(",
            ")"
        );
        if (header != null) joiner.add("header=" + header);
        if (value != null) joiner.add("value=" + value);
        return joiner.toString();
    }
}
