package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * A JSON-serializable model, describing how unsubscribes should
 * be handled.
 */
@JsonInclude(Include.NON_DEFAULT)
public class ASM {

    @JsonProperty("group_id")
    private int groupId;

    @JsonProperty("groups_to_display")
    private int[] groupsToDisplay;

    /**
     * Gets the group ID.
     *
     * @return the group ID.
     */
    @JsonProperty("group_id")
    public int getGroupId() {
        return groupId;
    }

    /**
     * Sets the group ID.
     *
     * @param groupId the group ID.
     * @return {@code this} for chaining.
     */
    public ASM groupId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    /**
     * Gets the groups to display.
     *
     * @return the groups to display.
     */
    @JsonProperty("groups_to_display")
    public int[] getGroupsToDisplay() {
        return groupsToDisplay;
    }

    /**
     * Sets the groups to display.
     *
     * @param groupsToDisplay the groups to display.
     * @return {@code this} for chaining.
     */
    public ASM groupsToDisplay(int[] groupsToDisplay) {
        this.groupsToDisplay = Arrays.copyOf(groupsToDisplay, groupsToDisplay.length);
        return this;
    }
}
