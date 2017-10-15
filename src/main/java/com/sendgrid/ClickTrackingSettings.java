package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A JSON-serializable model of the click tracking settings.
 * This allows for tracking a variety of the interactions a
 * recipient may make with your email.
 */
@JsonInclude(Include.NON_NULL)
public class ClickTrackingSettings {

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("enable_text")
    private boolean enableText;

    /**
     * Gets whether click tracking has been enabled.
     *
     * @return {@code true} if click tracking has been enabled;
     *         {@code false} otherwise.
     */
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }

    /**
     * Sets whether click tracking has been enabled.
     *
     * @param enable {@code true} if click tracking has been enabled;
     *               {@code false} otherwise.
     * @return {@code this} for chaining.
     */
    public ClickTrackingSettings enable(boolean enable) {
        this.enable = enable;
        return this;
    }

    /**
     * Gets the enabled text. This indicates if this
     * setting should be included in the text/plain 
     * portion of your email.
     *
     * @return the enable text.
     */
    @JsonProperty("enable_text")
    public boolean getEnableText() {
        return enableText;
    }

    /**
     * Sets the enabled text.
     *
     * @param enableText the enable text.
     * @return {@code this} for chaining.
     */
    public ClickTrackingSettings enableText(boolean enableText) {
        this.enableText = enableText;
        return this;
    }
}
