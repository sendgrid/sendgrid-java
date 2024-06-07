/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Single Sign-On API
 * The Single Sign-On API allows you to manage your SAML 2.0 SSO configurations. You can also work with your SSO integrations using the SSO section of the [Twilio SendGrid application user interface](https://app.sendgrid.com/settings/sso).  The Single Sign-On Settings operations allow you to create, retrieve, modify, and delete SSO integrations for your Twilio SendGrid account. Each integration will correspond to a specific IdP such as Okta, Duo, or Microsoft Azure Active Directory.  The Single Sign-On Certificates operations allow you to create, modify, and delete SSO certificates. A SAML certificate allows your IdP and Twilio SendGrid to verify requests are coming from one another using the `public_certificate` and `integration_id` parameters.  The Single Sign-On Teammates operations allow you to add and modify SSO Teammates. SSO Teammates are the individual user accounts who will access your Twilio SendGrid account with SSO credentials. To retrieve or delete an SSO Teammate, you will use the separate [Teammates API](https://docs.sendgrid.com/api-reference/teammates/).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.sso.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;


@ToString
public class SsoTeammatesRestrictedSubuserResponseProps {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("hasRestrictedSubuserAccess")
    @Getter
    @Setter
    private Boolean hasRestrictedSubuserAccess;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("subuserAccess")
    @Getter
    @Setter
    private List<SsoTeammatesRestrictedSubuserResponsePropsSubuserAccessInner> subuserAccess;

    public SsoTeammatesRestrictedSubuserResponseProps() {
    }

    private SsoTeammatesRestrictedSubuserResponseProps(Builder builder) {
        this.hasRestrictedSubuserAccess = builder.hasRestrictedSubuserAccess;
        this.subuserAccess = builder.subuserAccess;
    }

    // Builder class for constructing object
    public static class Builder {
        private Boolean hasRestrictedSubuserAccess;
        private List<SsoTeammatesRestrictedSubuserResponsePropsSubuserAccessInner> subuserAccess;

        public Builder() {
        }

        public Builder hasRestrictedSubuserAccess(Boolean hasRestrictedSubuserAccess) {
            this.hasRestrictedSubuserAccess = hasRestrictedSubuserAccess;
            return this;
        }

        public Builder subuserAccess(List<SsoTeammatesRestrictedSubuserResponsePropsSubuserAccessInner> subuserAccess) {
            this.subuserAccess = subuserAccess;
            return this;
        }

        public SsoTeammatesRestrictedSubuserResponseProps build() {
            return new SsoTeammatesRestrictedSubuserResponseProps(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", SsoTeammatesRestrictedSubuserResponseProps.class.getSimpleName() + "(", ")");
        if (hasRestrictedSubuserAccess != null) joiner.add("hasRestrictedSubuserAccess=" + hasRestrictedSubuserAccess);
        if (subuserAccess != null) joiner.add("subuserAccess=" + subuserAccess);
        return joiner.toString();
    }

}
         
    
