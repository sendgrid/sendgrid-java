/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Marketing Campaigns Contacts API
 * The Twilio SendGrid Marketing Campaigns Contacts API allows you to manage all of your marketing contacts programmatically. You can also import and export contacts using this API. The Contacts API allows you to associate contacts with lists and segments; however, to manage the lists and segments themselves, see the [Lists API](https://docs.sendgrid.com/api-reference/lists/) and [Segments API](https://docs.sendgrid.com/api-reference/segmenting-contacts-v2/).  You can also manage your marketing contacts with the [Marketing Campaigns application user interface](https://mc.sendgrid.com/contacts). See [**How to Send Email with New Marketing Campaigns**](https://docs.sendgrid.com/ui/sending-email/how-to-send-email-with-marketing-campaigns) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mccontacts.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;


@ToString
public class PostMarketingContactsBatch200Response {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("result")
    @Getter
    @Setter
    private List<ContactDetails3> result;

    public PostMarketingContactsBatch200Response() {
    }

    private PostMarketingContactsBatch200Response(Builder builder) {
        this.result = builder.result;
    }

    // Builder class for constructing object
    public static class Builder {
        private List<ContactDetails3> result;

        public Builder() {
        }

        public Builder result(List<ContactDetails3> result) {
            this.result = result;
            return this;
        }

        public PostMarketingContactsBatch200Response build() {
            return new PostMarketingContactsBatch200Response(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", PostMarketingContactsBatch200Response.class.getSimpleName() + "(", ")");
        if (result != null) joiner.add("result=" + result);
        return joiner.toString();
    }

}
         
    
