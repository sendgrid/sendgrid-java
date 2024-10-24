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
import com.sendgrid.rest.api.v3.teammates.models.InviteTeammate400ResponseErrorsInner;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class InviteTeammate400Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("errors")
    @Getter
    @Setter
    private List<InviteTeammate400ResponseErrorsInner> errors;

    public InviteTeammate400Response() {}

    private InviteTeammate400Response(Builder builder) {
        this.errors = builder.errors;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<InviteTeammate400ResponseErrorsInner> errors;

        public Builder() {}

        public Builder errors(
            List<InviteTeammate400ResponseErrorsInner> errors
        ) {
            this.errors = errors;
            return this;
        }

        public InviteTeammate400Response build() {
            return new InviteTeammate400Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            InviteTeammate400Response.class.getSimpleName() + "(",
            ")"
        );
        if (errors != null) joiner.add("errors=" + errors);
        return joiner.toString();
    }
}