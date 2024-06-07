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
public class PutIpsPoolsPoolName404ResponseErrorsInner {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("field")
    @Getter
    @Setter
    private String field;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("message")
    @Getter
    @Setter
    private String message;

    public PutIpsPoolsPoolName404ResponseErrorsInner() {
    }

    private PutIpsPoolsPoolName404ResponseErrorsInner(Builder builder) {
        this.field = builder.field;
        this.message = builder.message;
    }

    // Builder class for constructing object
    public static class Builder {
        private String field;
        private String message;

        public Builder() {
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public PutIpsPoolsPoolName404ResponseErrorsInner build() {
            return new PutIpsPoolsPoolName404ResponseErrorsInner(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", PutIpsPoolsPoolName404ResponseErrorsInner.class.getSimpleName() + "(", ")");
        if (field != null) joiner.add("field=" + field);
        if (message != null) joiner.add("message=" + message);
        return joiner.toString();
    }

}
         
    
