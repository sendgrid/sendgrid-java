/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid User API
 * The Twilio SendGrid User API allows you to modify the settings of a SendGrid user account such as the user's email address or username. Keeping your user profile up to date helps SendGrid verify who you are and share important communications with you.  See [**Account Details**](https://docs.sendgrid.com/ui/account-and-settings/account) for more information. You can also manage your user settings in the [SendGrid application user interface](https://app.sendgrid.com/account/details).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.user.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GETUserProfileResponse {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("address")
    @Getter
    @Setter
    private String address;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("address2")
    @Getter
    @Setter
    private String address2;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("city")
    @Getter
    @Setter
    private String city;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("company")
    @Getter
    @Setter
    private String company;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("country")
    @Getter
    @Setter
    private String country;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("first_name")
    @Getter
    @Setter
    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("last_name")
    @Getter
    @Setter
    private String lastName;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("phone")
    @Getter
    @Setter
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("state")
    @Getter
    @Setter
    private String state;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("website")
    @Getter
    @Setter
    private String website;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("zip")
    @Getter
    @Setter
    private String zip;

    public GETUserProfileResponse() {}

    private GETUserProfileResponse(Builder builder) {
        this.address = builder.address;
        this.address2 = builder.address2;
        this.city = builder.city;
        this.company = builder.company;
        this.country = builder.country;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.state = builder.state;
        this.website = builder.website;
        this.zip = builder.zip;
    }

    // Builder class for constructing object
    public static class Builder {

        private String address;
        private String address2;
        private String city;
        private String company;
        private String country;
        private String firstName;
        private String lastName;
        private String phone;
        private String state;
        private String website;
        private String zip;

        public Builder(
            String address,
            String city,
            String company,
            String country,
            String firstName,
            String lastName,
            String phone,
            String state,
            String website,
            String zip
        ) {
            this.address = address;
            this.city = city;
            this.company = company;
            this.country = country;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.state = state;
            this.website = website;
            this.zip = zip;
        }

        public Builder address2(String address2) {
            this.address2 = address2;
            return this;
        }

        public GETUserProfileResponse build() {
            return new GETUserProfileResponse(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            GETUserProfileResponse.class.getSimpleName() + "(",
            ")"
        );
        if (address != null) joiner.add("address=" + address);
        if (address2 != null) joiner.add("address2=" + address2);
        if (city != null) joiner.add("city=" + city);
        if (company != null) joiner.add("company=" + company);
        if (country != null) joiner.add("country=" + country);
        if (firstName != null) joiner.add("firstName=" + firstName);
        if (lastName != null) joiner.add("lastName=" + lastName);
        if (phone != null) joiner.add("phone=" + phone);
        if (state != null) joiner.add("state=" + state);
        if (website != null) joiner.add("website=" + website);
        if (zip != null) joiner.add("zip=" + zip);
        return joiner.toString();
    }
}