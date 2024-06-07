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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;


@ToString
public class ContactRequest {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("addressLine1")
    @Getter
    @Setter
    private String addressLine1;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("addressLine2")
    @Getter
    @Setter
    private String addressLine2;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("alternateEmails")
    @Getter
    @Setter
    private List<String> alternateEmails;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("city")
    @Getter
    @Setter
    private String city;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("country")
    @Getter
    @Setter
    private String country;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("email")
    @Getter
    @Setter
    private String email;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("phoneNumberId")
    @Getter
    @Setter
    private String phoneNumberId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("externalId")
    @Getter
    @Setter
    private String externalId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("anonymousId")
    @Getter
    @Setter
    private String anonymousId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("firstName")
    @Getter
    @Setter
    private String firstName;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("lastName")
    @Getter
    @Setter
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("postalCode")
    @Getter
    @Setter
    private String postalCode;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("stateProvinceRegion")
    @Getter
    @Setter
    private String stateProvinceRegion;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("customFields")
    @Getter
    @Setter
    private ContactRequestCustomFields customFields;

    public ContactRequest() {
    }

    private ContactRequest(Builder builder) {
        this.addressLine1 = builder.addressLine1;
        this.addressLine2 = builder.addressLine2;
        this.alternateEmails = builder.alternateEmails;
        this.city = builder.city;
        this.country = builder.country;
        this.email = builder.email;
        this.phoneNumberId = builder.phoneNumberId;
        this.externalId = builder.externalId;
        this.anonymousId = builder.anonymousId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.postalCode = builder.postalCode;
        this.stateProvinceRegion = builder.stateProvinceRegion;
        this.customFields = builder.customFields;
    }

    // Builder class for constructing object
    public static class Builder {
        private String addressLine1;
        private String addressLine2;
        private List<String> alternateEmails;
        private String city;
        private String country;
        private String email;
        private String phoneNumberId;
        private String externalId;
        private String anonymousId;
        private String firstName;
        private String lastName;
        private String postalCode;
        private String stateProvinceRegion;
        private ContactRequestCustomFields customFields;

        public Builder() {
        }

        public Builder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public Builder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public Builder alternateEmails(List<String> alternateEmails) {
            this.alternateEmails = alternateEmails;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumberId(String phoneNumberId) {
            this.phoneNumberId = phoneNumberId;
            return this;
        }

        public Builder externalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public Builder anonymousId(String anonymousId) {
            this.anonymousId = anonymousId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder stateProvinceRegion(String stateProvinceRegion) {
            this.stateProvinceRegion = stateProvinceRegion;
            return this;
        }

        public Builder customFields(ContactRequestCustomFields customFields) {
            this.customFields = customFields;
            return this;
        }

        public ContactRequest build() {
            return new ContactRequest(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", ContactRequest.class.getSimpleName() + "(", ")");
        if (addressLine1 != null) joiner.add("addressLine1=" + addressLine1);
        if (addressLine2 != null) joiner.add("addressLine2=" + addressLine2);
        if (alternateEmails != null) joiner.add("alternateEmails=" + alternateEmails);
        if (city != null) joiner.add("city=" + city);
        if (country != null) joiner.add("country=" + country);
        if (email != null) joiner.add("email=" + email);
        if (phoneNumberId != null) joiner.add("phoneNumberId=" + phoneNumberId);
        if (externalId != null) joiner.add("externalId=" + externalId);
        if (anonymousId != null) joiner.add("anonymousId=" + anonymousId);
        if (firstName != null) joiner.add("firstName=" + firstName);
        if (lastName != null) joiner.add("lastName=" + lastName);
        if (postalCode != null) joiner.add("postalCode=" + postalCode);
        if (stateProvinceRegion != null) joiner.add("stateProvinceRegion=" + stateProvinceRegion);
        if (customFields != null) joiner.add("customFields=" + customFields);
        return joiner.toString();
    }

}
         
    
