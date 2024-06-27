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
import com.sendgrid.rest.api.v3.ipaddressmanagement.models.ListIpPool200ResponseMetadata;
import com.sendgrid.rest.api.v3.ipaddressmanagement.models.ListIpPool200ResponseResultInner;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListIpPool200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("result")
    @Getter
    @Setter
    private List<ListIpPool200ResponseResultInner> result;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("_metadata")
    @Getter
    @Setter
    private ListIpPool200ResponseMetadata metadata;

    public ListIpPool200Response() {}

    private ListIpPool200Response(Builder builder) {
        this.result = builder.result;
        this.metadata = builder.metadata;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<ListIpPool200ResponseResultInner> result;
        private ListIpPool200ResponseMetadata metadata;

        public Builder() {}

        public Builder result(List<ListIpPool200ResponseResultInner> result) {
            this.result = result;
            return this;
        }

        public Builder metadata(ListIpPool200ResponseMetadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public ListIpPool200Response build() {
            return new ListIpPool200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListIpPool200Response.class.getSimpleName() + "(",
            ")"
        );
        if (result != null) joiner.add("result=" + result);
        if (metadata != null) joiner.add("metadata=" + metadata);
        return joiner.toString();
    }
}