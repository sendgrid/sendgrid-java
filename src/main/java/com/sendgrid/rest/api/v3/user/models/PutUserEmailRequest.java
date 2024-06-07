/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid User API
 * The Twilio SendGrid User API allows you to modify the settings of a SendGrid user account such as the user's email address or username. Keeping your user profile up to date helps SendGrid verify who you are and share important communications with you.  See [**Account Details**](https://docs.sendgrid.com/ui/account-and-settings/account) for more information. You can also manage your user settings in the [SendGrid application user interface](https://app.sendgrid.com/account/details).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.user.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class PutUserEmailRequest {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("email")
    @Getter
    @Setter
    private String email;

    public PutUserEmailRequest() {
    }

    private PutUserEmailRequest(Builder builder) {
        this.email = builder.email;
    }

    // Builder class for constructing object
    public static class Builder {
        private String email;

        public Builder() {
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public PutUserEmailRequest build() {
            return new PutUserEmailRequest(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", PutUserEmailRequest.class.getSimpleName() + "(", ")");
        if (email != null) joiner.add("email=" + email);
        return joiner.toString();
    }

}
         
    
