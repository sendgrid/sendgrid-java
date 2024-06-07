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
public class AccountProvisioningAccountId {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("accountId")
    @Getter
    @Setter
    private String accountId;

    public AccountProvisioningAccountId() {
    }

    private AccountProvisioningAccountId(Builder builder) {
        this.accountId = builder.accountId;
    }

    // Builder class for constructing object
    public static class Builder {
        private String accountId;

        public Builder(String accountId) {
            this.accountId = accountId;
        }

        public AccountProvisioningAccountId build() {
            return new AccountProvisioningAccountId(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", AccountProvisioningAccountId.class.getSimpleName() + "(", ")");
        if (accountId != null) joiner.add("accountId=" + accountId);
        return joiner.toString();
    }

}
         
    
