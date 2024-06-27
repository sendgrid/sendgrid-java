/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid API Keys API
 * The Twilio SendGrid API Keys API allows you manage your API keys and their settings. Your application, mail client, or website can all use API keys to authenticate access to SendGrid services.  To create your initial SendGrid API Key, you should use the [SendGrid application user interface](https://app.sendgrid.com/settings/api_keys). Once you have created a first key with scopes to manage additional API keys, you can use this API for all other key management.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.apikeys.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ApiKeyScopesResponse {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("scopes")
    @Getter
    @Setter
    private List<String> scopes;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("api_key_id")
    @Getter
    @Setter
    private String apiKeyId;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;

    public ApiKeyScopesResponse() {}

    private ApiKeyScopesResponse(Builder builder) {
        this.scopes = builder.scopes;
        this.apiKeyId = builder.apiKeyId;
        this.name = builder.name;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<String> scopes;
        private String apiKeyId;
        private String name;

        public Builder() {}

        public Builder scopes(List<String> scopes) {
            this.scopes = scopes;
            return this;
        }

        public Builder apiKeyId(String apiKeyId) {
            this.apiKeyId = apiKeyId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public ApiKeyScopesResponse build() {
            return new ApiKeyScopesResponse(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            ApiKeyScopesResponse.class.getSimpleName() + "(",
            ")"
        );
        if (scopes != null) joiner.add("scopes=" + scopes);
        if (apiKeyId != null) joiner.add("apiKeyId=" + apiKeyId);
        if (name != null) joiner.add("name=" + name);
        return joiner.toString();
    }
}