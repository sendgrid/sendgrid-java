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

import java.util.List;
import java.util.StringJoiner;


@ToString
public class PostWhitelabelDomainsRequest {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("domain")
    @Getter
    @Setter
    private String domain;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("subdomain")
    @Getter
    @Setter
    private String subdomain;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("username")
    @Getter
    @Setter
    private String username;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("ips")
    @Getter
    @Setter
    private List<String> ips;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("customSpf")
    @Getter
    @Setter
    private Boolean customSpf;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("_default")
    @Getter
    @Setter
    private Boolean _default;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("automaticSecurity")
    @Getter
    @Setter
    private Boolean automaticSecurity;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("customDkimSelector")
    @Getter
    @Setter
    private String customDkimSelector;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("region")
    @Getter
    @Setter
    private String region;

    public PostWhitelabelDomainsRequest() {
    }

    private PostWhitelabelDomainsRequest(Builder builder) {
        this.domain = builder.domain;
        this.subdomain = builder.subdomain;
        this.username = builder.username;
        this.ips = builder.ips;
        this.customSpf = builder.customSpf;
        this._default = builder._default;
        this.automaticSecurity = builder.automaticSecurity;
        this.customDkimSelector = builder.customDkimSelector;
        this.region = builder.region;
    }

    // Builder class for constructing object
    public static class Builder {
        private String domain;
        private String subdomain;
        private String username;
        private List<String> ips;
        private Boolean customSpf;
        private Boolean _default;
        private Boolean automaticSecurity;
        private String customDkimSelector;
        private String region;

        public Builder(String domain) {
            this.domain = domain;
        }

        public Builder subdomain(String subdomain) {
            this.subdomain = subdomain;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder ips(List<String> ips) {
            this.ips = ips;
            return this;
        }

        public Builder customSpf(Boolean customSpf) {
            this.customSpf = customSpf;
            return this;
        }

        public Builder _default(Boolean _default) {
            this._default = _default;
            return this;
        }

        public Builder automaticSecurity(Boolean automaticSecurity) {
            this.automaticSecurity = automaticSecurity;
            return this;
        }

        public Builder customDkimSelector(String customDkimSelector) {
            this.customDkimSelector = customDkimSelector;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public PostWhitelabelDomainsRequest build() {
            return new PostWhitelabelDomainsRequest(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", PostWhitelabelDomainsRequest.class.getSimpleName() + "(", ")");
        if (domain != null) joiner.add("domain=" + domain);
        if (subdomain != null) joiner.add("subdomain=" + subdomain);
        if (username != null) joiner.add("username=" + username);
        if (ips != null) joiner.add("ips=" + ips);
        if (customSpf != null) joiner.add("customSpf=" + customSpf);
        if (_default != null) joiner.add("_default=" + _default);
        if (automaticSecurity != null) joiner.add("automaticSecurity=" + automaticSecurity);
        if (customDkimSelector != null) joiner.add("customDkimSelector=" + customDkimSelector);
        if (region != null) joiner.add("region=" + region);
        return joiner.toString();
    }

}
         
    
