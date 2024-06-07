/*
 * This code was generated by
 *
 * SENDGRID-OAI-GENERATOR
 *
 * Twilio SendGrid Mail API
 * The Twilio SendGrid v3 Mail API allows you to send email at scale over HTTP. The Mail Send endpoint supports many levels of functionality, allowing you to send templates, set categories and custom arguments that can be used to analyze your send, and configure which tracking settings to include such as opens and clicks. You can also group mail sends into batches, allowing you to schedule and cancel sends by their batch IDs.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.sendgrid.rest.api.v3.mail.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.StringJoiner;


@ToString
public class PostMailSendRequestAsm {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("groupId")
    @Getter
    @Setter
    private Integer groupId;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("groupsToDisplay")
    @Getter
    @Setter
    private List<Integer> groupsToDisplay;

    public PostMailSendRequestAsm() {
    }

    private PostMailSendRequestAsm(Builder builder) {
        this.groupId = builder.groupId;
        this.groupsToDisplay = builder.groupsToDisplay;
    }

    // Builder class for constructing object
    public static class Builder {
        private Integer groupId;
        private List<Integer> groupsToDisplay;

        public Builder(Integer groupId) {
            this.groupId = groupId;
        }

        public Builder groupsToDisplay(List<Integer> groupsToDisplay) {
            this.groupsToDisplay = groupsToDisplay;
            return this;
        }

        public PostMailSendRequestAsm build() {
            return new PostMailSendRequestAsm(this);
        }

    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", PostMailSendRequestAsm.class.getSimpleName() + "(", ")");
        if (groupId != null) joiner.add("groupId=" + groupId);
        if (groupsToDisplay != null) joiner.add("groupsToDisplay=" + groupsToDisplay);
        return joiner.toString();
    }

}
         
    
