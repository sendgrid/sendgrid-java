/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Templates API
 * The Twilio SendGrid Templates API allows you to create and manage email templates to be delivered with SendGrid's sending APIs. The templates you create will be available using a template ID that is passed to our sending APIs as part of the request. Each template may then have multiple versions associated with it. Whichever version is set as \"active\" at the time of the request will be sent to your recipients. This system allows you to update a single template's look and feel entirely without modifying your requests to our Mail Send API. For example, you could have a single template for welcome emails. That welcome template could then have a version for each season of the year that's themed appropriately and marked as active during the appropriate season. The template ID passed to our sending APIs never needs to change; you can just modify which version is active.  This API provides operations to create and manage your templates as well as their versions.  Each user can create up to 300 different templates. Templates are specific to accounts and Subusers. Templates created on a parent account will not be accessible from the Subusers' accounts.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.templates.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.templates.models.Active1;
import com.sendgrid.rest.api.v3.templates.models.Editor1;
import java.util.StringJoiner;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class TransactionalTemplatesVersionOutputLean {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private UUID id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("template_id")
    @Getter
    @Setter
    private String templateId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("active")
    @Getter
    @Setter
    private Active1 active;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("subject")
    @Getter
    @Setter
    private String subject;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("updated_at")
    @Getter
    @Setter
    private String updatedAt;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("generate_plain_content")
    @Getter
    @Setter
    private Boolean generatePlainContent;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("html_content")
    @Getter
    @Setter
    private String htmlContent;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("plain_content")
    @Getter
    @Setter
    private String plainContent;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("editor")
    @Getter
    @Setter
    private Editor1 editor;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("thumbnail_url")
    @Getter
    @Setter
    private String thumbnailUrl;

    public TransactionalTemplatesVersionOutputLean() {}

    private TransactionalTemplatesVersionOutputLean(Builder builder) {
        this.id = builder.id;
        this.templateId = builder.templateId;
        this.active = builder.active;
        this.name = builder.name;
        this.subject = builder.subject;
        this.updatedAt = builder.updatedAt;
        this.generatePlainContent = builder.generatePlainContent;
        this.htmlContent = builder.htmlContent;
        this.plainContent = builder.plainContent;
        this.editor = builder.editor;
        this.thumbnailUrl = builder.thumbnailUrl;
    }

    // Builder class for constructing object
    public static class Builder {

        private UUID id;
        private String templateId;
        private Active1 active;
        private String name;
        private String subject;
        private String updatedAt;
        private Boolean generatePlainContent;
        private String htmlContent;
        private String plainContent;
        private Editor1 editor;
        private String thumbnailUrl;

        public Builder() {}

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder templateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Builder active(Active1 active) {
            this.active = active;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder generatePlainContent(Boolean generatePlainContent) {
            this.generatePlainContent = generatePlainContent;
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

        public Builder editor(Editor1 editor) {
            this.editor = editor;
            return this;
        }

        public Builder thumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        public TransactionalTemplatesVersionOutputLean build() {
            return new TransactionalTemplatesVersionOutputLean(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            TransactionalTemplatesVersionOutputLean.class.getSimpleName() + "(",
            ")"
        );
        if (id != null) joiner.add("id=" + id);
        if (templateId != null) joiner.add("templateId=" + templateId);
        if (active != null) joiner.add("active=" + active);
        if (name != null) joiner.add("name=" + name);
        if (subject != null) joiner.add("subject=" + subject);
        if (updatedAt != null) joiner.add("updatedAt=" + updatedAt);
        if (generatePlainContent != null) joiner.add(
            "generatePlainContent=" + generatePlainContent
        );
        if (htmlContent != null) joiner.add("htmlContent=" + htmlContent);
        if (plainContent != null) joiner.add("plainContent=" + plainContent);
        if (editor != null) joiner.add("editor=" + editor);
        if (thumbnailUrl != null) joiner.add("thumbnailUrl=" + thumbnailUrl);
        return joiner.toString();
    }
}