/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid IP Access Management API
 * IP Twilio SendGrid IP Access Management API allows you to control which IP addresses can be used to access your account, either through the SendGrid application user interface or the API.  There is no limit to the number of IP addresses that you can allow.  It is possible to remove your own IP address from your list of allowed addresses, thus blocking your own access to your account. While we are able to restore your access, we do require thorough proof of your identify and ownership of your account. We take the security of your account very seriously and wish to prevent any 'bad actors' from maliciously gaining access to your account. Your current IP is clearly displayed to help prevent you from accidentally removing it from the allowed addresses.  See [**IP Access Management**](https://docs.sendgrid.com/ui/account-and-settings/ip-access-management) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.ipaccessmanagement.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class PostAccessSettingsWhitelistRequestIpsInner {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("ip")
    @Getter
    @Setter
    private String ip;

    public PostAccessSettingsWhitelistRequestIpsInner() {
    }

    private PostAccessSettingsWhitelistRequestIpsInner(Builder builder) {
        this.ip = builder.ip;
    }

    // Builder class for constructing object
    public static class Builder {
        private String ip;

        public Builder(String ip) {
            this.ip = ip;
        }

        public PostAccessSettingsWhitelistRequestIpsInner build() {
            return new PostAccessSettingsWhitelistRequestIpsInner(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", PostAccessSettingsWhitelistRequestIpsInner.class.getSimpleName() + "(", ")");
        if (ip != null) joiner.add("ip=" + ip);
        return joiner.toString();
    }

}
         
    
