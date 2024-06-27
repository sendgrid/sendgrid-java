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
import com.sendgrid.rest.api.v3.ipaddressmanagement.models.IpAddressManagementErrorResponseErrorsInner;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class IpAddressManagementErrorResponse {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("errors")
    @Getter
    @Setter
    private List<IpAddressManagementErrorResponseErrorsInner> errors;

    public IpAddressManagementErrorResponse() {}

    private IpAddressManagementErrorResponse(Builder builder) {
        this.errors = builder.errors;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<IpAddressManagementErrorResponseErrorsInner> errors;

        public Builder() {}

        public Builder errors(
            List<IpAddressManagementErrorResponseErrorsInner> errors
        ) {
            this.errors = errors;
            return this;
        }

        public IpAddressManagementErrorResponse build() {
            return new IpAddressManagementErrorResponse(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            IpAddressManagementErrorResponse.class.getSimpleName() + "(",
            ")"
        );
        if (errors != null) joiner.add("errors=" + errors);
        return joiner.toString();
    }
}