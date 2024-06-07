/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Legacy Marketing Campaigns Contacts API
 * The Twilio SendGrid Legacy Marketing Campaigns Contacts API allows you to manage your marketing contacts programmatically. This API is operational, but we recommend using the current version of Marketing Campaigns' [Contacts API](https://docs.sendgrid.com/api-reference/contacts/), [Lists API](https://docs.sendgrid.com/api-reference/lists/), and [Segments API](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2/) to manage your contacts.  See [**Migrating from Legacy Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/migrating-from-legacy-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.lmccontactdb.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;


@ToString
public class PostContactdbRecipientsSearch200ResponseRecipientsInner {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("createdAt")
    @Getter
    @Setter
    private Integer createdAt;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("email")
    @Getter
    @Setter
    private String email;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private String id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("lastEmailed")
    @Getter
    @Setter
    private Integer lastEmailed;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("lastClicked")
    @Getter
    @Setter
    private Integer lastClicked;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("lastOpened")
    @Getter
    @Setter
    private Integer lastOpened;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("customFields")
    @Getter
    @Setter
    private List<PostContactdbRecipientsSearch200ResponseRecipientsInnerCustomFieldsInner> customFields;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("updatedAt")
    @Getter
    @Setter
    private Integer updatedAt;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("firstName")
    @Getter
    @Setter
    private String firstName;

    public PostContactdbRecipientsSearch200ResponseRecipientsInner() {
    }

    private PostContactdbRecipientsSearch200ResponseRecipientsInner(Builder builder) {
        this.createdAt = builder.createdAt;
        this.email = builder.email;
        this.id = builder.id;
        this.lastEmailed = builder.lastEmailed;
        this.lastClicked = builder.lastClicked;
        this.lastOpened = builder.lastOpened;
        this.customFields = builder.customFields;
        this.updatedAt = builder.updatedAt;
        this.firstName = builder.firstName;
    }

    // Builder class for constructing object
    public static class Builder {
        private Integer createdAt;
        private String email;
        private String id;
        private Integer lastEmailed;
        private Integer lastClicked;
        private Integer lastOpened;
        private List<PostContactdbRecipientsSearch200ResponseRecipientsInnerCustomFieldsInner> customFields;
        private Integer updatedAt;
        private String firstName;

        public Builder() {
        }

        public Builder createdAt(Integer createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder lastEmailed(Integer lastEmailed) {
            this.lastEmailed = lastEmailed;
            return this;
        }

        public Builder lastClicked(Integer lastClicked) {
            this.lastClicked = lastClicked;
            return this;
        }

        public Builder lastOpened(Integer lastOpened) {
            this.lastOpened = lastOpened;
            return this;
        }

        public Builder customFields(List<PostContactdbRecipientsSearch200ResponseRecipientsInnerCustomFieldsInner> customFields) {
            this.customFields = customFields;
            return this;
        }

        public Builder updatedAt(Integer updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PostContactdbRecipientsSearch200ResponseRecipientsInner build() {
            return new PostContactdbRecipientsSearch200ResponseRecipientsInner(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", PostContactdbRecipientsSearch200ResponseRecipientsInner.class.getSimpleName() + "(", ")");
        if (createdAt != null) joiner.add("createdAt=" + createdAt);
        if (email != null) joiner.add("email=" + email);
        if (id != null) joiner.add("id=" + id);
        if (lastEmailed != null) joiner.add("lastEmailed=" + lastEmailed);
        if (lastClicked != null) joiner.add("lastClicked=" + lastClicked);
        if (lastOpened != null) joiner.add("lastOpened=" + lastOpened);
        if (customFields != null) joiner.add("customFields=" + customFields);
        if (updatedAt != null) joiner.add("updatedAt=" + updatedAt);
        if (firstName != null) joiner.add("firstName=" + firstName);
        return joiner.toString();
    }

}
         
    
