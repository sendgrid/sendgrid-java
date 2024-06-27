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
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class GetIp200Response {

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

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("rdns")
    @Getter
    @Setter
    private String rdns;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("pools")
    @Getter
    @Setter
    private List<String> pools;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("warmup")
    @Getter
    @Setter
    private Boolean warmup;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("start_date")
    @Getter
    @Setter
    private Integer startDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("whitelabeled")
    @Getter
    @Setter
    private Boolean whitelabeled;

    public GetIp200Response() {}

    private GetIp200Response(Builder builder) {
        this.ip = builder.ip;
        this.subusers = builder.subusers;
        this.rdns = builder.rdns;
        this.pools = builder.pools;
        this.warmup = builder.warmup;
        this.startDate = builder.startDate;
        this.whitelabeled = builder.whitelabeled;
    }

    // Builder class for constructing object
    public static class Builder {

        private String ip;
        private List<String> subusers;
        private String rdns;
        private List<String> pools;
        private Boolean warmup;
        private Integer startDate;
        private Boolean whitelabeled;

        public Builder(
            String ip,
            List<String> subusers,
            String rdns,
            List<String> pools,
            Boolean warmup,
            Integer startDate,
            Boolean whitelabeled
        ) {
            this.ip = ip;
            this.subusers = subusers;
            this.rdns = rdns;
            this.pools = pools;
            this.warmup = warmup;
            this.startDate = startDate;
            this.whitelabeled = whitelabeled;
        }

        public GetIp200Response build() {
            return new GetIp200Response(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            GetIp200Response.class.getSimpleName() + "(",
            ")"
        );
        if (ip != null) joiner.add("ip=" + ip);
        if (subusers != null) joiner.add("subusers=" + subusers);
        if (rdns != null) joiner.add("rdns=" + rdns);
        if (pools != null) joiner.add("pools=" + pools);
        if (warmup != null) joiner.add("warmup=" + warmup);
        if (startDate != null) joiner.add("startDate=" + startDate);
        if (whitelabeled != null) joiner.add("whitelabeled=" + whitelabeled);
        return joiner.toString();
    }
}