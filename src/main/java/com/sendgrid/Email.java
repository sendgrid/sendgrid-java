package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An email address represented as an address name pair.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Email {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    /**
     * Construct an empty email.
     */
    public Email() {

    }

    /**
     * Get the name.
     * @return the name.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     * @param name the name.
     * @return this object.
     */
    public Email name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the email address.
     * @return the email address.
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address.
     * @param email the email address.
     * @return this object.
     */
    public Email email(String email) {
        this.email = email;
        return this;
    }
}
