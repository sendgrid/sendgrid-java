package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A generic setting object.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Setting {

    @JsonProperty("enable")
    private boolean enable;

    /**
     * Get whether or not this setting is enabled.
     * @return true if the setting is enabled, false otherwise.
     */
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }

    /**
     * Set whether or not this setting is enabled.
     * @param enable true if the setting is enabled, false otherwise.
     * @return this object.
     */
    public Setting enable(boolean enable) {
        this.enable = enable;
        return this;
    }
}
