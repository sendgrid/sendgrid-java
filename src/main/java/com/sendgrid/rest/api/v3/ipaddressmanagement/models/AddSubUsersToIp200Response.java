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
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AddSubUsersToIp200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("ip")
    @Getter
    @Setter
    private String ip;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("subusers")
    @Getter
    @Setter
    private List<String> subusers;

    public AddSubUsersToIp200Response() {}

    private AddSubUsersToIp200Response(Builder builder) {
        this.ip = builder.ip;
        this.subusers = builder.subusers;
    }

    // Builder class for constructing object
    public static class Builder {

        private String ip;
        private List<String> subusers;

        public Builder() {}

        public Builder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder subusers(List<String> subusers) {
            this.subusers = subusers;
            return this;
        }

        public AddSubUsersToIp200Response build() {
            return new AddSubUsersToIp200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            AddSubUsersToIp200Response.class.getSimpleName() + "(",
            ")"
        );
        if (ip != null) joiner.add("ip=" + ip);
        if (subusers != null) joiner.add("subusers=" + subusers);
        return joiner.toString();
    }
}