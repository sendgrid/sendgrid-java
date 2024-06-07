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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;


@ToString
public class ApiKeyScopesResponse {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("apiKeyId")
    @Getter
    @Setter
    private Object apiKeyId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private Object name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("scopes")
    @Getter
    @Setter
    private List<String> scopes;

    public ApiKeyScopesResponse() {
    }

    private ApiKeyScopesResponse(Builder builder) {
        this.apiKeyId = builder.apiKeyId;
        this.name = builder.name;
        this.scopes = builder.scopes;
    }

    // Builder class for constructing object
    public static class Builder {
        private Object apiKeyId;
        private Object name;
        private List<String> scopes;

        public Builder() {
        }

        public Builder apiKeyId(Object apiKeyId) {
            this.apiKeyId = apiKeyId;
            return this;
        }

        public Builder name(Object name) {
            this.name = name;
            return this;
        }

        public Builder scopes(List<String> scopes) {
            this.scopes = scopes;
            return this;
        }

        public ApiKeyScopesResponse build() {
            return new ApiKeyScopesResponse(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", ApiKeyScopesResponse.class.getSimpleName() + "(", ")");
        if (apiKeyId != null) joiner.add("apiKeyId=" + apiKeyId);
        if (name != null) joiner.add("name=" + name);
        if (scopes != null) joiner.add("scopes=" + scopes);
        return joiner.toString();
    }

}
         
    
