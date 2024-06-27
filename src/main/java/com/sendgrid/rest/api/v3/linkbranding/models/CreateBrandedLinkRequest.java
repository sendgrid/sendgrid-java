/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Link Branding API
 * The Twilio SendGrid Link Branding API allows you to configure your domain settings so that all of the click-tracked links, opens, and images in your emails are served from your domain rather than `sendgrid.net`. Spam filters and recipient servers look at the links within emails to determine whether the email appear trustworthy. They use the reputation of the root domain to determine whether the links can be trusted.  You can also manage Link Branding in the **Sender Authentication** section of the Twilio SendGrid application user interface.   See [**How to Set Up Link Branding**](https: //sendgrid.com/docs/ui/account-and-settings/how-to-set-up-link-branding/) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.linkbranding.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.linkbranding.models.ModelDefault;
import com.sendgrid.rest.api.v3.linkbranding.models.Region;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class CreateBrandedLinkRequest {

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
    @JsonProperty("default")
    @Getter
    @Setter
    private ModelDefault _default;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("region")
    @Getter
    @Setter
    private Region region;

    public CreateBrandedLinkRequest() {}

    private CreateBrandedLinkRequest(Builder builder) {
        this.domain = builder.domain;
        this.subdomain = builder.subdomain;
        this._default = builder._default;
        this.region = builder.region;
    }

    // Builder class for constructing object
    public static class Builder {

        private String domain;
        private String subdomain;
        private ModelDefault _default;
        private Region region;

        public Builder(String domain) {
            this.domain = domain;
        }

        public Builder subdomain(String subdomain) {
            this.subdomain = subdomain;
            return this;
        }

        public Builder _default(ModelDefault _default) {
            this._default = _default;
            return this;
        }

        public Builder region(Region region) {
            this.region = region;
            return this;
        }

        public CreateBrandedLinkRequest build() {
            return new CreateBrandedLinkRequest(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            CreateBrandedLinkRequest.class.getSimpleName() + "(",
            ")"
        );
        if (domain != null) joiner.add("domain=" + domain);
        if (subdomain != null) joiner.add("subdomain=" + subdomain);
        if (_default != null) joiner.add("_default=" + _default);
        if (region != null) joiner.add("region=" + region);
        return joiner.toString();
    }
}