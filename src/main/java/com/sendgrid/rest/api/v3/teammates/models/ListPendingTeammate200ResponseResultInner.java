/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Teammates API
 * The Twilio SendGrid Teammates API allows you to add, manage, and remove Teammates, or user accounts, from your SendGrid account. Teammates function like user accounts on the SendGrid account, allowing you to invite additional users to your account with scoped access. You can think of Teammates as SendGrid's approach to enabling [role-based access control](https://en.wikipedia.org/wiki/Role-based_access_control) for your SendGrid account. For even more control over the access to your account, see the [Twilio SendGrid SSO API](https://docs.sendgrid.com/api-reference/single-sign-on-teammates/), which enables SSO-authenticated Teammates to be managed through a SAML 2.0 identity provider.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.teammates.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListPendingTeammate200ResponseResultInner {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("email")
    @Getter
    @Setter
    private String email;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("scopes")
    @Getter
    @Setter
    private List<String> scopes;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("is_admin")
    @Getter
    @Setter
    private Boolean isAdmin;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("token")
    @Getter
    @Setter
    private String token;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("expiration_date")
    @Getter
    @Setter
    private Integer expirationDate;

    public ListPendingTeammate200ResponseResultInner() {}

    private ListPendingTeammate200ResponseResultInner(Builder builder) {
        this.email = builder.email;
        this.scopes = builder.scopes;
        this.isAdmin = builder.isAdmin;
        this.token = builder.token;
        this.expirationDate = builder.expirationDate;
    }

    // Builder class for constructing object
    public static class Builder {

        private String email;
        private List<String> scopes;
        private Boolean isAdmin;
        private String token;
        private Integer expirationDate;

        public Builder() {}

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder scopes(List<String> scopes) {
            this.scopes = scopes;
            return this;
        }

        public Builder isAdmin(Boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder expirationDate(Integer expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public ListPendingTeammate200ResponseResultInner build() {
            return new ListPendingTeammate200ResponseResultInner(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListPendingTeammate200ResponseResultInner.class.getSimpleName() +
            "(",
            ")"
        );
        if (email != null) joiner.add("email=" + email);
        if (scopes != null) joiner.add("scopes=" + scopes);
        if (isAdmin != null) joiner.add("isAdmin=" + isAdmin);
        if (token != null) joiner.add("token=" + token);
        if (expirationDate != null) joiner.add(
            "expirationDate=" + expirationDate
        );
        return joiner.toString();
    }
}