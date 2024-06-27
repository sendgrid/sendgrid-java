/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Subusers
 * The Twilio SendGrid Subusers API allows you to create and manage your Subuser accounts. Subusers are available on [Pro and Premier plans](https://sendgrid.com/pricing), and you can think of them as sub-accounts. Each Subuser can have its own sending domains, IP addresses, and reporting. SendGrid recommends creating Subusers for each of the different types of emails you send—one Subuser for transactional emails and another for marketing emails. Independent Software Vendor (ISV) customers may also create Subusers for each of their customers.  You can also manage Subusers in the [Twilio SendGrid application user interface](https://app.sendgrid.com/settings/subusers). See [**Subusers**](https://docs.sendgrid.com/ui/account-and-settings/subusers) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.subusers.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.rest.api.v3.subusers.models.Region2;
import java.math.BigDecimal;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Subuser {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("disabled")
    @Getter
    @Setter
    private Boolean disabled;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private BigDecimal id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("username")
    @Getter
    @Setter
    private String username;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("email")
    @Getter
    @Setter
    private String email;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("region")
    @Getter
    @Setter
    private Region2 region;

    public Subuser() {}

    private Subuser(Builder builder) {
        this.disabled = builder.disabled;
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.region = builder.region;
    }

    // Builder class for constructing object
    public static class Builder {

        private Boolean disabled;
        private BigDecimal id;
        private String username;
        private String email;
        private Region2 region;

        public Builder(
            Boolean disabled,
            BigDecimal id,
            String username,
            String email
        ) {
            this.disabled = disabled;
            this.id = id;
            this.username = username;
            this.email = email;
        }

        public Builder region(Region2 region) {
            this.region = region;
            return this;
        }

        public Subuser build() {
            return new Subuser(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            Subuser.class.getSimpleName() + "(",
            ")"
        );
        if (disabled != null) joiner.add("disabled=" + disabled);
        if (id != null) joiner.add("id=" + id);
        if (username != null) joiner.add("username=" + username);
        if (email != null) joiner.add("email=" + email);
        if (region != null) joiner.add("region=" + region);
        return joiner.toString();
    }
}
