package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A JSON-serializable representation of the content of an email.
 * <p>
 * This class has the capabilities to be chained, like so:
 * <code>
 *     final Content content = new Content()
 *             .type(ContentType.TEXT_PLAIN)
 *             .value("Hello, World!");
 * </code>
 */
@JsonInclude(Include.NON_DEFAULT)
public class Content {

    @JsonProperty("type")
    private String type;

    @JsonProperty("value")
    private String value;

    /**
     * Creates a new content wrapper, with no content.
     */
    public Content() {
    }

    /**
     * Gets the mime type of the content of the email. For example,
     * {@code text/plain} or {@code text/html}.
     *
     * @return the mime type.
     * @see ContentType for a psuedo-enum of potential content types
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Sets the mime type of the content of the email. For example,
     * {@code text/plain} or {@code text/html}.
     *
     * @param type the mime type.
     * @return {@code this} for chaining.
     * @see ContentType for a psuedo-enum of potential content types
     */
    public Content type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Gets the content of the email. The type of the content should
     * match the specified mime type.
     *
     * @return the content.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Sets the content of the email. The type of the content should
     * match the specified mime type.
     *
     * @param value the content.
     * @return {@code this} for chaining.
     */
    public Content value(String value) {
        this.value = value;
        return this;
    }
}
