/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Account Provisioning API
 * The Twilio SendGrid Account Provisioning API provides a platform for Twilio SendGrid resellers to manage their customer accounts. This API is for companies that have a formal reseller partnership with Twilio SendGrid.  You can access Twilio SendGrid sub-account functionality without becoming a reseller. If you require sub-account functionality, see the Twilio [SendGrid Subusers](https://docs.sendgrid.com/ui/account-and-settings/subusers) feature, which is available with [Pro and Premier plans](https://sendgrid.com/pricing/).
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.accountprovisioning.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;


@ToString
public class AccountProvisioningOfferingV1 {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("name")
    @Getter
    @Setter
    private String name;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("type")
    @Getter
    @Setter
    private Type type;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("quantity")
    @Getter
    @Setter
    private Long quantity;

    public AccountProvisioningOfferingV1() {
    }

    private AccountProvisioningOfferingV1(Builder builder) {
        this.name = builder.name;
        this.type = builder.type;
        this.quantity = builder.quantity;
    }

    // Builder class for constructing object
    public static class Builder {
        private String name;
        private Type type;
        private Long quantity;

        public Builder(String name, Type type) {
            this.name = name;
            this.type = type;
        }

        public Builder quantity(Long quantity) {
            this.quantity = quantity;
            return this;
        }

        public AccountProvisioningOfferingV1 build() {
            return new AccountProvisioningOfferingV1(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", AccountProvisioningOfferingV1.class.getSimpleName() + "(", ")");
        if (name != null) joiner.add("name=" + name);
        if (type != null) joiner.add("type=" + type);
        if (quantity != null) joiner.add("quantity=" + quantity);
        return joiner.toString();
    }

}
         
    
