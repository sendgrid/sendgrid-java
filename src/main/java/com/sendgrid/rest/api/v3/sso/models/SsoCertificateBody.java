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
public class SsoCertificateBody {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("public_certificate")
    @Getter
    @Setter
    private String publicCertificate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private BigDecimal id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("not_before")
    @Getter
    @Setter
    private BigDecimal notBefore;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("not_after")
    @Getter
    @Setter
    private BigDecimal notAfter;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("intergration_id")
    @Getter
    @Setter
    private String intergrationId;

    public SsoCertificateBody() {}

    private SsoCertificateBody(Builder builder) {
        this.publicCertificate = builder.publicCertificate;
        this.id = builder.id;
        this.notBefore = builder.notBefore;
        this.notAfter = builder.notAfter;
        this.intergrationId = builder.intergrationId;
    }

    // Builder class for constructing object
    public static class Builder {

        private String publicCertificate;
        private BigDecimal id;
        private BigDecimal notBefore;
        private BigDecimal notAfter;
        private String intergrationId;

        public Builder() {}

        public Builder publicCertificate(String publicCertificate) {
            this.publicCertificate = publicCertificate;
            return this;
        }

        public Builder id(BigDecimal id) {
            this.id = id;
            return this;
        }

        public Builder notBefore(BigDecimal notBefore) {
            this.notBefore = notBefore;
            return this;
        }

        public Builder notAfter(BigDecimal notAfter) {
            this.notAfter = notAfter;
            return this;
        }

        public Builder intergrationId(String intergrationId) {
            this.intergrationId = intergrationId;
            return this;
        }

        public SsoCertificateBody build() {
            return new SsoCertificateBody(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            SsoCertificateBody.class.getSimpleName() + "(",
            ")"
        );
        if (publicCertificate != null) joiner.add(
            "publicCertificate=" + publicCertificate
        );
        if (id != null) joiner.add("id=" + id);
        if (notBefore != null) joiner.add("notBefore=" + notBefore);
        if (notAfter != null) joiner.add("notAfter=" + notAfter);
        if (intergrationId != null) joiner.add(
            "intergrationId=" + intergrationId
        );
        return joiner.toString();
    }
}