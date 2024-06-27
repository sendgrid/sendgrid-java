/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Legacy Marketing Campaigns Campaigns API
 * The Twilio SendGrid Legacy Marketing Campaigns Campaigns API allows you to manage your marketing email messages programmatically. This API is operational, but we recommend using the current version of Marketing Campaigns to manage your marketing messages with SendGrid [Single Sends](https://docs.sendgrid.com/api-reference/single-sends/) and [Automations](https://docs.sendgrid.com/ui/sending-email/getting-started-with-automation).  See [**Migrating from Legacy Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/migrating-from-legacy-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.lmccampaigns.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GetCampaign200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("categories")
    @Getter
    @Setter
    private List<String> categories;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("custom_unsubscribe_url")
    @Getter
    @Setter
    private String customUnsubscribeUrl;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("html_content")
    @Getter
    @Setter
    private String htmlContent;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("ip_pool")
    @Getter
    @Setter
    private String ipPool;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("list_ids")
    @Getter
    @Setter
    private List<Integer> listIds;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("plain_content")
    @Getter
    @Setter
    private String plainContent;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("segment_ids")
    @Getter
    @Setter
    private List<Integer> segmentIds;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("sender_id")
    @Getter
    @Setter
    private Integer senderId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("status")
    @Getter
    @Setter
    private String status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("subject")
    @Getter
    @Setter
    private String subject;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("suppression_group_id")
    @Getter
    @Setter
    private Integer suppressionGroupId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("title")
    @Getter
    @Setter
    private String title;

    public GetCampaign200Response() {}

    private GetCampaign200Response(Builder builder) {
        this.categories = builder.categories;
        this.customUnsubscribeUrl = builder.customUnsubscribeUrl;
        this.htmlContent = builder.htmlContent;
        this.id = builder.id;
        this.ipPool = builder.ipPool;
        this.listIds = builder.listIds;
        this.plainContent = builder.plainContent;
        this.segmentIds = builder.segmentIds;
        this.senderId = builder.senderId;
        this.status = builder.status;
        this.subject = builder.subject;
        this.suppressionGroupId = builder.suppressionGroupId;
        this.title = builder.title;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<String> categories;
        private String customUnsubscribeUrl;
        private String htmlContent;
        private Integer id;
        private String ipPool;
        private List<Integer> listIds;
        private String plainContent;
        private List<Integer> segmentIds;
        private Integer senderId;
        private String status;
        private String subject;
        private Integer suppressionGroupId;
        private String title;

        public Builder() {}

        public Builder categories(List<String> categories) {
            this.categories = categories;
            return this;
        }

        public Builder customUnsubscribeUrl(String customUnsubscribeUrl) {
            this.customUnsubscribeUrl = customUnsubscribeUrl;
            return this;
        }

        public Builder htmlContent(String htmlContent) {
            this.htmlContent = htmlContent;
            return this;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder ipPool(String ipPool) {
            this.ipPool = ipPool;
            return this;
        }

        public Builder listIds(List<Integer> listIds) {
            this.listIds = listIds;
            return this;
        }

        public Builder plainContent(String plainContent) {
            this.plainContent = plainContent;
            return this;
        }

        public Builder segmentIds(List<Integer> segmentIds) {
            this.segmentIds = segmentIds;
            return this;
        }

        public Builder senderId(Integer senderId) {
            this.senderId = senderId;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder suppressionGroupId(Integer suppressionGroupId) {
            this.suppressionGroupId = suppressionGroupId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public GetCampaign200Response build() {
            return new GetCampaign200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            GetCampaign200Response.class.getSimpleName() + "(",
            ")"
        );
        if (categories != null) joiner.add("categories=" + categories);
        if (customUnsubscribeUrl != null) joiner.add(
            "customUnsubscribeUrl=" + customUnsubscribeUrl
        );
        if (htmlContent != null) joiner.add("htmlContent=" + htmlContent);
        if (id != null) joiner.add("id=" + id);
        if (ipPool != null) joiner.add("ipPool=" + ipPool);
        if (listIds != null) joiner.add("listIds=" + listIds);
        if (plainContent != null) joiner.add("plainContent=" + plainContent);
        if (segmentIds != null) joiner.add("segmentIds=" + segmentIds);
        if (senderId != null) joiner.add("senderId=" + senderId);
        if (status != null) joiner.add("status=" + status);
        if (subject != null) joiner.add("subject=" + subject);
        if (suppressionGroupId != null) joiner.add(
            "suppressionGroupId=" + suppressionGroupId
        );
        if (title != null) joiner.add("title=" + title);
        return joiner.toString();
    }
}