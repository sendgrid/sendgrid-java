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

import java.util.List;
import java.util.StringJoiner;


@ToString
public class SegmentWriteV2 {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("parentListIds")
    @Getter
    @Setter
    private List<String> parentListIds;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("queryDsl")
    @Getter
    @Setter
    private String queryDsl;

    public SegmentWriteV2() {
    }

    private SegmentWriteV2(Builder builder) {
        this.name = builder.name;
        this.parentListIds = builder.parentListIds;
        this.queryDsl = builder.queryDsl;
    }

    // Builder class for constructing object
    public static class Builder {
        private String name;
        private List<String> parentListIds;
        private String queryDsl;

        public Builder(String name, String queryDsl) {
            this.name = name;
            this.queryDsl = queryDsl;
        }

        public Builder parentListIds(List<String> parentListIds) {
            this.parentListIds = parentListIds;
            return this;
        }

        public SegmentWriteV2 build() {
            return new SegmentWriteV2(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", SegmentWriteV2.class.getSimpleName() + "(", ")");
        if (name != null) joiner.add("name=" + name);
        if (parentListIds != null) joiner.add("parentListIds=" + parentListIds);
        if (queryDsl != null) joiner.add("queryDsl=" + queryDsl);
        return joiner.toString();
    }

}
         
    
