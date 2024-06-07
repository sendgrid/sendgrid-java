/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid IP Address API
 * The Twilio SendGrid IP Address API allows you to add and manage dedicated IP addresses and IP Pools for your SendGrid account and Subusers. If you are sending any significant amount of email, SendGrid typically suggests sending from dedicated IPs. It's also best to send marketing and transactional emails from separate IP addresses. In order to do this, you'll need to set up IP Pools, which are groups of dedicated IP addresses you define to send particular types of messages. See the [**Dedicated IP Addresses**](https://docs.sendgrid.com/ui/account-and-settings/dedicated-ip-addresses) for more information about obtaining and allocating IPs.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.ips.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class IpPools200 {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    public IpPools200() {
    }

    private IpPools200(Builder builder) {
        this.name = builder.name;
    }

    // Builder class for constructing object
    public static class Builder {
        private String name;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public IpPools200 build() {
            return new IpPools200(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", IpPools200.class.getSimpleName() + "(", ")");
        if (name != null) joiner.add("name=" + name);
        return joiner.toString();
    }

}
         
    
