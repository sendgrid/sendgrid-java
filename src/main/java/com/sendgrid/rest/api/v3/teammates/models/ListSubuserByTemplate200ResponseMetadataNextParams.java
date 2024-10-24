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
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListSubuserByTemplate200ResponseMetadataNextParams {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("limit")
    @Getter
    @Setter
    private Integer limit;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("after_subuser_id")
    @Getter
    @Setter
    private Integer afterSubuserId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("username")
    @Getter
    @Setter
    private String username;

    public ListSubuserByTemplate200ResponseMetadataNextParams() {}

    private ListSubuserByTemplate200ResponseMetadataNextParams(
        Builder builder
    ) {
        this.limit = builder.limit;
        this.afterSubuserId = builder.afterSubuserId;
        this.username = builder.username;
    }

    // Builder class for constructing object
    public static class Builder {

        private Integer limit;
        private Integer afterSubuserId;
        private String username;

        public Builder() {}

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder afterSubuserId(Integer afterSubuserId) {
            this.afterSubuserId = afterSubuserId;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public ListSubuserByTemplate200ResponseMetadataNextParams build() {
            return new ListSubuserByTemplate200ResponseMetadataNextParams(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListSubuserByTemplate200ResponseMetadataNextParams.class.getSimpleName() +
            "(",
            ")"
        );
        if (limit != null) joiner.add("limit=" + limit);
        if (afterSubuserId != null) joiner.add(
            "afterSubuserId=" + afterSubuserId
        );
        if (username != null) joiner.add("username=" + username);
        return joiner.toString();
    }
}