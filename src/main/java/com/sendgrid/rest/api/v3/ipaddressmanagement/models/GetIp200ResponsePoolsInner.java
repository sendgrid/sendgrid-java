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
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GetIp200ResponsePoolsInner {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("id")
    @Getter
    @Setter
    private String id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    public GetIp200ResponsePoolsInner() {}

    private GetIp200ResponsePoolsInner(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    // Builder class for constructing object
    public static class Builder {

        private String id;
        private String name;

        public Builder() {}

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public GetIp200ResponsePoolsInner build() {
            return new GetIp200ResponsePoolsInner(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            GetIp200ResponsePoolsInner.class.getSimpleName() + "(",
            ")"
        );
        if (id != null) joiner.add("id=" + id);
        if (name != null) joiner.add("name=" + name);
        return joiner.toString();
    }
}