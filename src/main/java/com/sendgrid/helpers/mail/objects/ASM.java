package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * An object allowing you to specify how to handle unsubscribes.
 */
@JsonInclude(Include.NON_DEFAULT)
public class ASM {

  /** The group ID. */
  @JsonProperty("group_id") private int groupId;

  /** The groups to display property. */
  @JsonProperty("groups_to_display") private int[] groupsToDisplay;

  /**
   * Get the group ID.
   * @return the group ID.
   */
  @JsonProperty("group_id")
  public int getGroupId() {
    return groupId;
  }

  /**
   * Set the group ID.
   * @param groupId the group ID.
   */
  public void setGroupId(int groupId) {
    this.groupId = groupId;
  }

  /**
   * Get the groups to display.
   * @return the groups to display.
   */
  @JsonProperty("groups_to_display")
  public int[] getGroupsToDisplay() {
    return groupsToDisplay;
  }

  /**
   * Set the groups to display.
   * @param groupsToDisplay the groups to display.
   */
  public void setGroupsToDisplay(int[] groupsToDisplay) {
    this.groupsToDisplay = Arrays.copyOf(groupsToDisplay, groupsToDisplay.length);
  }
}
