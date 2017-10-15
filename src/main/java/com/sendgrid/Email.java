package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A JSON-serializable representation of an email address pair.
 * <p>
 * This class has the capabilities to be chained, like so:
 * <code>
 *     final Email email = new Email()
 *             .name("John Doe")
 *             .email("john@doe.com");
 * </code>
 */
@JsonInclude(Include.NON_DEFAULT)
public class Email {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    /**
     * Creates a new email wrapper, with no name or email.
     */
    public Email() {
    }

    /**
     * Gets the <em>human-readable</em> name of the email owner - for
     * example: <code>John Doe</code>.
     *
     * @return the <em>human-readable</em> name.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Sets the <em>human-readable</em> name of the email owner.
     *
     * @param name the <em>human-readable</em> name.
     * @return {@code this} for chaining.
     */
    public Email name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the email address - for example: <code>john@doe.com</code>.
     *
     * @return the email address.
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     *
     * @param email the email address.
     * @return {@code this} for chaining.
     */
    public Email email(String email) {
        this.email = email;
        return this;
    }
}
