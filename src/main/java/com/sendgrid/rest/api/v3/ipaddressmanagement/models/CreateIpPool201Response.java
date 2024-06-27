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
public class CreateIpPool201Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private String id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("ips")
    @Getter
    @Setter
    private List<String> ips;

    public CreateIpPool201Response() {}

    private CreateIpPool201Response(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.ips = builder.ips;
    }

    // Builder class for constructing object
    public static class Builder {

        private String name;
        private String id;
        private List<String> ips;

        public Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder ips(List<String> ips) {
            this.ips = ips;
            return this;
        }

        public CreateIpPool201Response build() {
            return new CreateIpPool201Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            CreateIpPool201Response.class.getSimpleName() + "(",
            ")"
        );
        if (name != null) joiner.add("name=" + name);
        if (id != null) joiner.add("id=" + id);
        if (ips != null) joiner.add("ips=" + ips);
        return joiner.toString();
    }
}