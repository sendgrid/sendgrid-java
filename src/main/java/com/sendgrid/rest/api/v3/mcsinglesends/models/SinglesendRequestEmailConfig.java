/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Single Sends API
 * The Twilio SendGrid Single Sends API allows you to create, manage, and send Single Sends. You can also search Single Sends and retrieve statistics about them to help you maintain, alter, and further develop your campaigns.  A Single Send is a one-time non-automated email message delivered to a list or segment of your audience. A Single Send may be sent immediately or scheduled for future delivery.  Single Sends can serve many use cases, including promotional offers, engagement campaigns, newsletters, announcements, legal notices, or policy updates. You can also create and manage Single Sends in the [Marketing Campaigns application user interface](https://mc.sendgrid.com/single-sends).  The Single Sends API changed on May 6, 2020. See [**Single Sends 2020 Update**](https://docs.sendgrid.com/for-developers/sending-email/single-sends-2020-update) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mcsinglesends.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.net.URI;
import java.util.StringJoiner;


@ToString
public class SinglesendRequestEmailConfig {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("subject")
    @Getter
    @Setter
    private String subject;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("htmlContent")
    @Getter
    @Setter
    private String htmlContent;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("plainContent")
    @Getter
    @Setter
    private String plainContent;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("generatePlainContent")
    @Getter
    @Setter
    private Boolean generatePlainContent;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("designId")
    @Getter
    @Setter
    private String designId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("editor")
    @Getter
    @Setter
    private Editor editor;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("suppressionGroupId")
    @Getter
    @Setter
    private Integer suppressionGroupId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("customUnsubscribeUrl")
    @Getter
    @Setter
    private URI customUnsubscribeUrl;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("senderId")
    @Getter
    @Setter
    private Integer senderId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("ipPool")
    @Getter
    @Setter
    private String ipPool;

    public SinglesendRequestEmailConfig() {
    }

    private SinglesendRequestEmailConfig(Builder builder) {
        this.subject = builder.subject;
        this.htmlContent = builder.htmlContent;
        this.plainContent = builder.plainContent;
        this.generatePlainContent = builder.generatePlainContent;
        this.designId = builder.designId;
        this.editor = builder.editor;
        this.suppressionGroupId = builder.suppressionGroupId;
        this.customUnsubscribeUrl = builder.customUnsubscribeUrl;
        this.senderId = builder.senderId;
        this.ipPool = builder.ipPool;
    }

    // Builder class for constructing object
    public static class Builder {
        private String subject;
        private String htmlContent;
        private String plainContent;
        private Boolean generatePlainContent;
        private String designId;
        private Editor editor;
        private Integer suppressionGroupId;
        private URI customUnsubscribeUrl;
        private Integer senderId;
        private String ipPool;

        public Builder() {
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder htmlContent(String htmlContent) {
            this.htmlContent = htmlContent;
            return this;
        }

        public Builder plainContent(String plainContent) {
            this.plainContent = plainContent;
            return this;
        }

        public Builder generatePlainContent(Boolean generatePlainContent) {
            this.generatePlainContent = generatePlainContent;
            return this;
        }

        public Builder designId(String designId) {
            this.designId = designId;
            return this;
        }

        public Builder editor(Editor editor) {
            this.editor = editor;
            return this;
        }

        public Builder suppressionGroupId(Integer suppressionGroupId) {
            this.suppressionGroupId = suppressionGroupId;
            return this;
        }

        public Builder customUnsubscribeUrl(URI customUnsubscribeUrl) {
            this.customUnsubscribeUrl = customUnsubscribeUrl;
            return this;
        }

        public Builder senderId(Integer senderId) {
            this.senderId = senderId;
            return this;
        }

        public Builder ipPool(String ipPool) {
            this.ipPool = ipPool;
            return this;
        }

        public SinglesendRequestEmailConfig build() {
            return new SinglesendRequestEmailConfig(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", SinglesendRequestEmailConfig.class.getSimpleName() + "(", ")");
        if (subject != null) joiner.add("subject=" + subject);
        if (htmlContent != null) joiner.add("htmlContent=" + htmlContent);
        if (plainContent != null) joiner.add("plainContent=" + plainContent);
        if (generatePlainContent != null) joiner.add("generatePlainContent=" + generatePlainContent);
        if (designId != null) joiner.add("designId=" + designId);
        if (editor != null) joiner.add("editor=" + editor);
        if (suppressionGroupId != null) joiner.add("suppressionGroupId=" + suppressionGroupId);
        if (customUnsubscribeUrl != null) joiner.add("customUnsubscribeUrl=" + customUnsubscribeUrl);
        if (senderId != null) joiner.add("senderId=" + senderId);
        if (ipPool != null) joiner.add("ipPool=" + ipPool);
        return joiner.toString();
    }

}
         
    
