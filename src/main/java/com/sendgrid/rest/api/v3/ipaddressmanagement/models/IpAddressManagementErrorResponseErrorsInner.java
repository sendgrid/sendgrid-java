/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid IP Address Management API
 * The Twilio SendGrid IP Address Management API combines functionality that was previously split between the Twilio SendGrid [IP Address API](https://docs.sendgrid.com/api-reference/ip-address) and [IP Pools API](https://docs.sendgrid.com/api-reference/ip-pools). This functionality includes adding IP addresses to your account, assigning IP addresses to IP Pools and Subusers, among other tasks.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.ipaddressmanagement.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class IpAddressManagementErrorResponseErrorsInner {
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

    public IpAddressManagementErrorResponseErrorsInner() {
    }

    private IpAddressManagementErrorResponseErrorsInner(Builder builder) {
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

        public IpAddressManagementErrorResponseErrorsInner build() {
            return new IpAddressManagementErrorResponseErrorsInner(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", IpAddressManagementErrorResponseErrorsInner.class.getSimpleName() + "(", ")");
        if (field != null) joiner.add("field=" + field);
        if (message != null) joiner.add("message=" + message);
        return joiner.toString();
    }

}
         
    
