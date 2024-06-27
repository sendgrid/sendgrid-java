/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Subusers
 * The Twilio SendGrid Subusers API allows you to create and manage your Subuser accounts. Subusers are available on [Pro and Premier plans](https://sendgrid.com/pricing), and you can think of them as sub-accounts. Each Subuser can have its own sending domains, IP addresses, and reporting. SendGrid recommends creating Subusers for each of the different types of emails you send—one Subuser for transactional emails and another for marketing emails. Independent Software Vendor (ISV) customers may also create Subusers for each of their customers.  You can also manage Subusers in the [Twilio SendGrid application user interface](https://app.sendgrid.com/settings/subusers). See [**Subusers**](https://docs.sendgrid.com/ui/account-and-settings/subusers) for more information.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sendgrid.rest.api.v3.subusers.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class UpdateSubuserRemainingCreditRequest {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("allocation_update")
    @Getter
    @Setter
    private Integer allocationUpdate;

    public UpdateSubuserRemainingCreditRequest() {}

    private UpdateSubuserRemainingCreditRequest(Builder builder) {
        this.allocationUpdate = builder.allocationUpdate;
    }

    // Builder class for constructing object
    public static class Builder {

        private Integer allocationUpdate;

        public Builder(Integer allocationUpdate) {
            this.allocationUpdate = allocationUpdate;
        }

        public UpdateSubuserRemainingCreditRequest build() {
            return new UpdateSubuserRemainingCreditRequest(this);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(
            ", ",
            UpdateSubuserRemainingCreditRequest.class.getSimpleName() + "(",
            ")"
        );
        if (allocationUpdate != null) joiner.add(
            "allocationUpdate=" + allocationUpdate
        );
        return joiner.toString();
    }
}