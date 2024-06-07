/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Segments API
 * This API was deprecated on December 31, 2022. Following deprecation, all segments created in the Marketing Campaigns user interface began using the [Segmentation v2 API](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2).  To enable manual migration and data retrieval, this API's GET and DELETE operations will remain available. The POST (create) and PATCH (update) endpoints were removed on January 31, 2023 because it is no longer possible to create new v1 segments or modify existing ones. See our [Segmentation v1 to v2 upgrade instructions](https://docs.sendgrid.com/for-developers/sending-email/getting-started-the-marketing-campaigns-v2-segmentation-api#upgrade-a-v1-segment-to-v2) to manually migrate your segments to the v2 API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mcsegments.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class ContactResponseCustomFields {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("customFieldName1")
    @Getter
    @Setter
    private String customFieldName1;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("customFieldName2")
    @Getter
    @Setter
    private String customFieldName2;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("")
    @Getter
    @Setter
    private String;

    public ContactResponseCustomFields() {
    }

    private ContactResponseCustomFields(Builder builder) {
        this.customFieldName1 = builder.customFieldName1;
        this.customFieldName2 = builder.customFieldName2;
        this. = builder.;
    }

    // Builder class for constructing object
    public static class Builder {
        private String customFieldName1;
        private String customFieldName2;
        private String;

        public Builder() {
        }

        public Builder customFieldName1(String customFieldName1) {
            this.customFieldName1 = customFieldName1;
            return this;
        }

        public Builder customFieldName2(String customFieldName2) {
            this.customFieldName2 = customFieldName2;
            return this;
        }

        public Builder(String) {
            this. =;
            return this;
        }

        public ContactResponseCustomFields build() {
            return new ContactResponseCustomFields(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", ContactResponseCustomFields.class.getSimpleName() + "(", ")");
        if (customFieldName1 != null) joiner.add("customFieldName1=" + customFieldName1);
        if (customFieldName2 != null) joiner.add("customFieldName2=" + customFieldName2);
        if ( !=null)joiner.add("=" +);
        return joiner.toString();
    }

}
         
    
