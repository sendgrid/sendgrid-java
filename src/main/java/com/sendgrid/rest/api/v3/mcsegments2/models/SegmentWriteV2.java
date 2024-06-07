/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Segments 2.0 API
 * The Twilio SendGrid Marketing Campaigns Segments V2 API allows you to create, edit, and delete segments as well as retrieve a list of segments or an individual segment by ID.  Segments are similar to contact lists, except they update dynamically over time as information stored about your contacts or the criteria used to define your segments changes. When you segment your audience, you are able to create personalized Automation emails and Single Sends that directly address the wants and needs of your particular audience.  Note that Twilio SendGrid checks for newly added or modified contacts who meet a segment's criteria on an hourly schedule. Only existing contacts who meet a segment's criteria will be included in the segment searches within 15 minutes.  Segments built using engagement data such as \"was sent\" or \"clicked\" will take approximately 30 minutes to begin populating.  Segment samples and counts are refreshed approximately once per hour; they do not update immediately. If no contacts are added to or removed from a segment since the last refresh, the sample and UI count displayed will be refreshed at increasing time intervals with a maximum sample and count refresh delay of 24 hours.  You can also manage your Segments with the [Marketing Campaigns application user interface](https://mc.sendgrid.com/contacts). See [**Segmenting Your Contacts**](https://docs.sendgrid.com/ui/managing-contacts/segmenting-your-contacts) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mcsegments2.models;

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
         
    
