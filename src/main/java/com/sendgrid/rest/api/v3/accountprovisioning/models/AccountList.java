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
import com.sendgrid.rest.api.v3.accountprovisioning.models.AccountProvisioningAccount;
import com.sendgrid.rest.api.v3.accountprovisioning.models.AccountProvisioningPagination;
import java.util.List;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class AccountList {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("accounts")
    @Getter
    @Setter
    private List<AccountProvisioningAccount> accounts;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("pages")
    @Getter
    @Setter
    private AccountProvisioningPagination pages;

    public AccountList() {}

    private AccountList(Builder builder) {
        this.accounts = builder.accounts;
        this.pages = builder.pages;
    }

    // Builder class for constructing object
    public static class Builder {

        private List<AccountProvisioningAccount> accounts;
        private AccountProvisioningPagination pages;

        public Builder() {}

        public Builder accounts(List<AccountProvisioningAccount> accounts) {
            this.accounts = accounts;
            return this;
        }

        public Builder pages(AccountProvisioningPagination pages) {
            this.pages = pages;
            return this;
        }

        public AccountList build() {
            return new AccountList(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            AccountList.class.getSimpleName() + "(",
            ")"
        );
        if (accounts != null) joiner.add("accounts=" + accounts);
        if (pages != null) joiner.add("pages=" + pages);
        return joiner.toString();
    }
}