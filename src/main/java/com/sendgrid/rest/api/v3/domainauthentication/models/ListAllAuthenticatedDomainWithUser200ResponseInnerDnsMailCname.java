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
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListAllAuthenticatedDomainWithUser200ResponseInnerDnsMailCname {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("valid")
    @Getter
    @Setter
    private Boolean valid;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("type")
    @Getter
    @Setter
    private String type;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("host")
    @Getter
    @Setter
    private String host;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("data")
    @Getter
    @Setter
    private String data;

    public ListAllAuthenticatedDomainWithUser200ResponseInnerDnsMailCname() {}

    private ListAllAuthenticatedDomainWithUser200ResponseInnerDnsMailCname(
        Builder builder
    ) {
        this.valid = builder.valid;
        this.type = builder.type;
        this.host = builder.host;
        this.data = builder.data;
    }

    // Builder class for constructing object
    public static class Builder {

        private Boolean valid;
        private String type;
        private String host;
        private String data;

        public Builder(Boolean valid, String type, String host, String data) {
            this.valid = valid;
            this.type = type;
            this.host = host;
            this.data = data;
        }

        public ListAllAuthenticatedDomainWithUser200ResponseInnerDnsMailCname build() {
            return new ListAllAuthenticatedDomainWithUser200ResponseInnerDnsMailCname(
                this
            );
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListAllAuthenticatedDomainWithUser200ResponseInnerDnsMailCname.class.getSimpleName() +
            "(",
            ")"
        );
        if (valid != null) joiner.add("valid=" + valid);
        if (type != null) joiner.add("type=" + type);
        if (host != null) joiner.add("host=" + host);
        if (data != null) joiner.add("data=" + data);
        return joiner.toString();
    }
}