package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A JSON-serializable model of the blind carbon copy (BCC)
 * settings. This allows for automatic copies of every
 * email sent to be made to the specified email address.
 */
@JsonInclude(Include.NON_NULL)
public class BCCSettings {

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("email")
    private String email;

    /**
     * Gets whether BCC has been enabled.
     *
     * @return {@code true} if BCC has been enabled;
     *         {@code false} otherwise.
     */
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }

    /**
     * Sets whether BCC has been enabled.
     *
     * @param enable {@code true} if BCC has been enabled;
     *               {@code false} otherwise.
     * @return {@code this} for chaining.
     */
    public BCCSettings enable(boolean enable) {
        this.enable = enable;
        return this;
    }

    /**
     * Gets the email address that will receive the copies.
     *
     * @return the email address.
     */
    @JsonProperty("email")
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email address that will receive the copies.
     *
     * @param email the email address.
     * @return {@code this} for chaining.
     */
    public BCCSettings email(String email) {
        this.email = email;
        return this;
    }
}
