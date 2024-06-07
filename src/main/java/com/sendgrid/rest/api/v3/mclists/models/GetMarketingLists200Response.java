/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Lists API
 * The Twilio SendGrid Marketing Campaigns Lists API allows you to manage your contacts lists programmatically. Lists are static collections of Marketing Campaigns contacts. You can use this API to interact with the list objects themselves. To add contacts to a list, you must use the [Contacts API](https://docs.sendgrid.com/api-reference/contacts/).  You can also manage your lists using the Contacts menu in the [Marketing Campaigns application user interface](https://mc.sendgrid.com/contacts). For more information about lists and best practices for building them, see [**Building your Contact Lists**](https://sendgrid.com/docs/ui/managing-contacts/building-your-contact-list/).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mclists.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;


@ToString
public class GetMarketingLists200Response {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("result")
    @Getter
    @Setter
    private List<ModelList> result;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("metadata")
    @Getter
    @Setter
    private Metadata metadata;

    public GetMarketingLists200Response() {
    }

    private GetMarketingLists200Response(Builder builder) {
        this.result = builder.result;
        this.metadata = builder.metadata;
    }

    // Builder class for constructing object
    public static class Builder {
        private List<ModelList> result;
        private Metadata metadata;

        public Builder() {
        }

        public Builder result(List<ModelList> result) {
            this.result = result;
            return this;
        }

        public Builder metadata(Metadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public GetMarketingLists200Response build() {
            return new GetMarketingLists200Response(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", GetMarketingLists200Response.class.getSimpleName() + "(", ")");
        if (result != null) joiner.add("result=" + result);
        if (metadata != null) joiner.add("metadata=" + metadata);
        return joiner.toString();
    }

}
         
    
