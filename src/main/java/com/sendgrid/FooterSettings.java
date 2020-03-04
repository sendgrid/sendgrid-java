package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A JSON-serializable model of the footer settings.
 * This allows for a default footer to be included
 * on every email sent.
 */
@JsonInclude(Include.NON_NULL)
public class FooterSettings {

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("text")
    private String text;

    @JsonProperty("html")
    private String html;

    /**
     * Gets whether the footer has been enabled.
     *
     * @return {@code true} if the footer has been enabled;
     *         {@code false} otherwise.
     */
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }

    /**
     * Sets whether the footer has been enabled.
     *
     * @param enable {@code true} if the footer has been enabled;
     *               {@code false} otherwise.
     * @return {@code this} for chaining.
     */
    public FooterSettings enable(boolean enable) {
        this.enable = enable;
        return this;
    }

    /**
     * Gets the plain text content of the footer.
     *
     * @return the footer plain text.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * Sets the plain text content of the footer.
     *
     * @param text the footer plain text.
     * @return {@code this} for chaining.
     */
    public FooterSettings text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Gets the HTML content of the footer.
     *
     * @return the footer HTML.
     */
    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    /**
     * Sets the HTML content of the footer.
     *
     * @param html the footer HTML.
     * @return {@code this} for chaining.
     */
    public FooterSettings html(String html) {
        this.html = html;
        return this;
    }
}
