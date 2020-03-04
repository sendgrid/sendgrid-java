package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A JSON-serializable setting that can be toggled.
 * <p>
 * This class has the capabilities to be chained, like so:
 * <code>
 *     final Setting setting = new Setting()
 *             .enable(true);
 * </code>
 */
@JsonInclude(Include.NON_DEFAULT)
public class Setting {

    @JsonProperty("enable")
    private boolean enable;

    /**
     * Creates a new setting.
     */
    public Setting() {
    }

    /**
     * Gets whether the setting is enabled.
     *
     * @return {@code true} if the setting has been enabled;
     *         {@code false} otherwise.
     */
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }

    /**
     * Sets whether the setting is enabled.
     *
     * @param enable {@code true} if the setting is to be enabled;
     *               {@code false} if the setting is to be disabled.
     * @return {@code this} for chaining.
     */
    public Setting enable(boolean enable) {
        this.enable = enable;
        return this;
    }
}
