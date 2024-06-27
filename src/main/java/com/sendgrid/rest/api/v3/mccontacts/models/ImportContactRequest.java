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
import com.sendgrid.rest.api.v3.mccontacts.models.FileType1;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ImportContactRequest {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("list_ids")
    @Getter
    @Setter
    private List<String> listIds;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("file_type")
    @Getter
    @Setter
    private FileType1 fileType;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("field_mappings")
    @Getter
    @Setter
    private List<String> fieldMappings;

    public ImportContactRequest() {}

    private ImportContactRequest(Builder builder) {
        this.listIds = builder.listIds;
        this.fileType = builder.fileType;
        this.fieldMappings = builder.fieldMappings;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<String> listIds;
        private FileType1 fileType;
        private List<String> fieldMappings;

        public Builder(FileType1 fileType, List<String> fieldMappings) {
            this.fileType = fileType;
            this.fieldMappings = fieldMappings;
        }

        public Builder listIds(List<String> listIds) {
            this.listIds = listIds;
            return this;
        }

        public ImportContactRequest build() {
            return new ImportContactRequest(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ImportContactRequest.class.getSimpleName() + "(",
            ")"
        );
        if (listIds != null) joiner.add("listIds=" + listIds);
        if (fileType != null) joiner.add("fileType=" + fileType);
        if (fieldMappings != null) joiner.add("fieldMappings=" + fieldMappings);
        return joiner.toString();
    }
}