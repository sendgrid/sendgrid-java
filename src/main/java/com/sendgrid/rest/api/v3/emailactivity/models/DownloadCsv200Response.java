/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Email Activity API
 * The Twilio SendGrid Email Activity API allows you to query all of your stored messages, query individual messages, and download a CSV with data about the stored messages. Once retrieved, you can inspect the data associated with your messages to better understand your mail send. For example, you may retrieve all bounced messages or all messages with the same subject line and search for commonalities among them.  You must [purchase additional email activity history](https://app.sendgrid.com/settings/billing/addons/email_activity) to gain access to the Email Activity Feed API.  See **Getting Started with the Email Activity Feed API** for help building queries and working with this API. You can also work with email activity in the **Activity** section of the [Twilio SendGrid application user interface](https://app.sendgrid.com/email_activity).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.emailactivity.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DownloadCsv200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("presigned_url")
    @Getter
    @Setter
    private URI presignedUrl;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("csv")
    @Getter
    @Setter
    private String csv;

    public DownloadCsv200Response() {}

    private DownloadCsv200Response(Builder builder) {
        this.presignedUrl = builder.presignedUrl;
        this.csv = builder.csv;
    }

    // Builder class for constructing object
    public static class Builder {

        private URI presignedUrl;
        private String csv;

        public Builder(String csv) {
            this.csv = csv;
        }

        public Builder presignedUrl(URI presignedUrl) {
            this.presignedUrl = presignedUrl;
            return this;
        }

        public DownloadCsv200Response build() {
            return new DownloadCsv200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            DownloadCsv200Response.class.getSimpleName() + "(",
            ")"
        );
        if (presignedUrl != null) joiner.add("presignedUrl=" + presignedUrl);
        if (csv != null) joiner.add("csv=" + csv);
        return joiner.toString();
    }
}
