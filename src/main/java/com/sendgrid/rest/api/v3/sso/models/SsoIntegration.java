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
import java.math.BigDecimal;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class SsoIntegration {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("enabled")
    @Getter
    @Setter
    private Boolean enabled;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("signin_url")
    @Getter
    @Setter
    private String signinUrl;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("signout_url")
    @Getter
    @Setter
    private String signoutUrl;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("entity_id")
    @Getter
    @Setter
    private String entityId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("completed_integration")
    @Getter
    @Setter
    private Boolean completedIntegration;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("last_updated")
    @Getter
    @Setter
    private BigDecimal lastUpdated;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private String id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("single_signon_url")
    @Getter
    @Setter
    private String singleSignonUrl;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("audience_url")
    @Getter
    @Setter
    private String audienceUrl;

    public SsoIntegration() {}

    private SsoIntegration(Builder builder) {
        this.name = builder.name;
        this.enabled = builder.enabled;
        this.signinUrl = builder.signinUrl;
        this.signoutUrl = builder.signoutUrl;
        this.entityId = builder.entityId;
        this.completedIntegration = builder.completedIntegration;
        this.lastUpdated = builder.lastUpdated;
        this.id = builder.id;
        this.singleSignonUrl = builder.singleSignonUrl;
        this.audienceUrl = builder.audienceUrl;
    }

    // Builder class for constructing object
    public static class Builder {

        private String name;
        private Boolean enabled;
        private String signinUrl;
        private String signoutUrl;
        private String entityId;
        private Boolean completedIntegration;
        private BigDecimal lastUpdated;
        private String id;
        private String singleSignonUrl;
        private String audienceUrl;

        public Builder(
            String name,
            Boolean enabled,
            String signinUrl,
            String signoutUrl,
            String entityId,
            BigDecimal lastUpdated
        ) {
            this.name = name;
            this.enabled = enabled;
            this.signinUrl = signinUrl;
            this.signoutUrl = signoutUrl;
            this.entityId = entityId;
            this.lastUpdated = lastUpdated;
        }

        public Builder completedIntegration(Boolean completedIntegration) {
            this.completedIntegration = completedIntegration;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder singleSignonUrl(String singleSignonUrl) {
            this.singleSignonUrl = singleSignonUrl;
            return this;
        }

        public Builder audienceUrl(String audienceUrl) {
            this.audienceUrl = audienceUrl;
            return this;
        }

        public SsoIntegration build() {
            return new SsoIntegration(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            SsoIntegration.class.getSimpleName() + "(",
            ")"
        );
        if (name != null) joiner.add("name=" + name);
        if (enabled != null) joiner.add("enabled=" + enabled);
        if (signinUrl != null) joiner.add("signinUrl=" + signinUrl);
        if (signoutUrl != null) joiner.add("signoutUrl=" + signoutUrl);
        if (entityId != null) joiner.add("entityId=" + entityId);
        if (completedIntegration != null) joiner.add(
            "completedIntegration=" + completedIntegration
        );
        if (lastUpdated != null) joiner.add("lastUpdated=" + lastUpdated);
        if (id != null) joiner.add("id=" + id);
        if (singleSignonUrl != null) joiner.add(
            "singleSignonUrl=" + singleSignonUrl
        );
        if (audienceUrl != null) joiner.add("audienceUrl=" + audienceUrl);
        return joiner.toString();
    }
}
