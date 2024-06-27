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
import com.sendgrid.rest.api.v3.ips.models.ListRemainingIpCount200ResponseResultsInner;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ListRemainingIpCount200Response {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("results")
    @Getter
    @Setter
    private List<ListRemainingIpCount200ResponseResultsInner> results;

    public ListRemainingIpCount200Response() {}

    private ListRemainingIpCount200Response(Builder builder) {
        this.results = builder.results;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<ListRemainingIpCount200ResponseResultsInner> results;

        public Builder(
            List<ListRemainingIpCount200ResponseResultsInner> results
        ) {
            this.results = results;
        }

        public ListRemainingIpCount200Response build() {
            return new ListRemainingIpCount200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ListRemainingIpCount200Response.class.getSimpleName() + "(",
            ")"
        );
        if (results != null) joiner.add("results=" + results);
        return joiner.toString();
    }
}
