/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Domain Authentication API
 * The Twilio SendGrid Domain Authentication API allows you to manage your authenticated domains and their settings.  Domain Authentication is a required step when setting up your Twilio SendGrid account because it's essential to ensuring the deliverability of your email. Domain Authentication signals trustworthiness to email inbox providers and your recipients by approving SendGrid to send email on behalf of your domain. For more information, see [**How to Set Up Domain Authentication**](https://sendgrid.com/docs/ui/account-and-settings/how-to-set-up-domain-authentication/).  Each user may have a maximum of 3,000 authenticated domains and 3,000 link brandings. This limit is at the user level, meaning each Subuser belonging to a parent account may have its own 3,000 authenticated domains and 3,000 link brandings.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.domainauthentication.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class AuthenticatedDomainSpfDnsDkim {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("host")
    @Getter
    @Setter
    private String host;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("type")
    @Getter
    @Setter
    private String type;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("data")
    @Getter
    @Setter
    private String data;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("valid")
    @Getter
    @Setter
    private Boolean valid;

    public AuthenticatedDomainSpfDnsDkim() {
    }

    private AuthenticatedDomainSpfDnsDkim(Builder builder) {
        this.host = builder.host;
        this.type = builder.type;
        this.data = builder.data;
        this.valid = builder.valid;
    }

    // Builder class for constructing object
    public static class Builder {
        private String host;
        private String type;
        private String data;
        private Boolean valid;

        public Builder(String host, String type, String data, Boolean valid) {
            this.host = host;
            this.type = type;
            this.data = data;
            this.valid = valid;
        }

        public AuthenticatedDomainSpfDnsDkim build() {
            return new AuthenticatedDomainSpfDnsDkim(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", AuthenticatedDomainSpfDnsDkim.class.getSimpleName() + "(", ")");
        if (host != null) joiner.add("host=" + host);
        if (type != null) joiner.add("type=" + type);
        if (data != null) joiner.add("data=" + data);
        if (valid != null) joiner.add("valid=" + valid);
        return joiner.toString();
    }

}
         
    
