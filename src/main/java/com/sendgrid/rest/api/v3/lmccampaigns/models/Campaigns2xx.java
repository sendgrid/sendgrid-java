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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class Campaigns2xx {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("title")
    @Getter
    @Setter
    private Object title;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("subject")
    @Getter
    @Setter
    private Object subject;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("senderId")
    @Getter
    @Setter
    private Object senderId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("listIds")
    @Getter
    @Setter
    private Object listIds;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("segmentIds")
    @Getter
    @Setter
    private Object segmentIds;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("categories")
    @Getter
    @Setter
    private Object categories;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("suppressionGroupId")
    @Getter
    @Setter
    private Object suppressionGroupId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("customUnsubscribeUrl")
    @Getter
    @Setter
    private Object customUnsubscribeUrl;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("ipPool")
    @Getter
    @Setter
    private Object ipPool;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("htmlContent")
    @Getter
    @Setter
    private Object htmlContent;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("plainContent")
    @Getter
    @Setter
    private Object plainContent;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("editor")
    @Getter
    @Setter
    private Editor editor;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("status")
    @Getter
    @Setter
    private String status;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private Integer id;

    public Campaigns2xx() {
    }

    private Campaigns2xx(Builder builder) {
        this.title = builder.title;
        this.subject = builder.subject;
        this.senderId = builder.senderId;
        this.listIds = builder.listIds;
        this.segmentIds = builder.segmentIds;
        this.categories = builder.categories;
        this.suppressionGroupId = builder.suppressionGroupId;
        this.customUnsubscribeUrl = builder.customUnsubscribeUrl;
        this.ipPool = builder.ipPool;
        this.htmlContent = builder.htmlContent;
        this.plainContent = builder.plainContent;
        this.editor = builder.editor;
        this.status = builder.status;
        this.id = builder.id;
    }

    // Builder class for constructing object
    public static class Builder {
        private Object title;
        private Object subject;
        private Object senderId;
        private Object listIds;
        private Object segmentIds;
        private Object categories;
        private Object suppressionGroupId;
        private Object customUnsubscribeUrl;
        private Object ipPool;
        private Object htmlContent;
        private Object plainContent;
        private Editor editor;
        private String status;
        private Integer id;

        public Builder(Object title, String status) {
            this.title = title;
            this.status = status;
        }

        public Builder subject(Object subject) {
            this.subject = subject;
            return this;
        }

        public Builder senderId(Object senderId) {
            this.senderId = senderId;
            return this;
        }

        public Builder listIds(Object listIds) {
            this.listIds = listIds;
            return this;
        }

        public Builder segmentIds(Object segmentIds) {
            this.segmentIds = segmentIds;
            return this;
        }

        public Builder categories(Object categories) {
            this.categories = categories;
            return this;
        }

        public Builder suppressionGroupId(Object suppressionGroupId) {
            this.suppressionGroupId = suppressionGroupId;
            return this;
        }

        public Builder customUnsubscribeUrl(Object customUnsubscribeUrl) {
            this.customUnsubscribeUrl = customUnsubscribeUrl;
            return this;
        }

        public Builder ipPool(Object ipPool) {
            this.ipPool = ipPool;
            return this;
        }

        public Builder htmlContent(Object htmlContent) {
            this.htmlContent = htmlContent;
            return this;
        }

        public Builder plainContent(Object plainContent) {
            this.plainContent = plainContent;
            return this;
        }

        public Builder editor(Editor editor) {
            this.editor = editor;
            return this;
        }

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Campaigns2xx build() {
            return new Campaigns2xx(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", Campaigns2xx.class.getSimpleName() + "(", ")");
        if (title != null) joiner.add("title=" + title);
        if (subject != null) joiner.add("subject=" + subject);
        if (senderId != null) joiner.add("senderId=" + senderId);
        if (listIds != null) joiner.add("listIds=" + listIds);
        if (segmentIds != null) joiner.add("segmentIds=" + segmentIds);
        if (categories != null) joiner.add("categories=" + categories);
        if (suppressionGroupId != null) joiner.add("suppressionGroupId=" + suppressionGroupId);
        if (customUnsubscribeUrl != null) joiner.add("customUnsubscribeUrl=" + customUnsubscribeUrl);
        if (ipPool != null) joiner.add("ipPool=" + ipPool);
        if (htmlContent != null) joiner.add("htmlContent=" + htmlContent);
        if (plainContent != null) joiner.add("plainContent=" + plainContent);
        if (editor != null) joiner.add("editor=" + editor);
        if (status != null) joiner.add("status=" + status);
        if (id != null) joiner.add("id=" + id);
        return joiner.toString();
    }

}
         
    
