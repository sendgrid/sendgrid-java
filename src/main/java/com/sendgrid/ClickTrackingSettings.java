package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Settings to determine how you would like to track the 
 * metrics of how your recipients interact with your email.
 */
@JsonInclude(Include.NON_DEFAULT)
public class ClickTrackingSettings {

    @JsonProperty("enable")
    private boolean enable;

    @JsonProperty("enable_text")
    private boolean enableText;

    /**
     * Determines if this setting is enabled.
     * @return true if click tracking is enabled, false otherwise.
     */
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }

    /**
     * Set if this setting is enabled.
     * @param enable true if click tracking is enabled, false otherwise.
     * @return this object.
     */
    public ClickTrackingSettings enable(boolean enable) {
        this.enable = enable;
        return this;
    }

    /**
     * Get the enabled text. This indicates if this 
     * setting should be included in the text/plain 
     * portion of your email.
     * @return the enable text.
     */
    @JsonProperty("enable_text")
    public boolean getEnableText() {
        return enableText;
    }

    /**
     * Set the enalbed text.
     * @param enableText the enable text.
     * @return this object.
     */
    public ClickTrackingSettings enableText(boolean enableText) {
        this.enableText = enableText;
        return this;
    }
}
