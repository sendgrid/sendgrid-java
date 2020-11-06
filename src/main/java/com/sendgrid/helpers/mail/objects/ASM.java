package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

@JsonInclude(Include.NON_DEFAULT)
public class ASM {

  @JsonProperty("group_id")
  private int groupId;

  @JsonProperty("groups_to_display")
  private int[] groupsToDisplay;

  @JsonProperty("group_id")
  public int getGroupId() {
    return groupId;
  }

  public void setGroupId(int groupId) {
    this.groupId = groupId;
  }

  @JsonProperty("groups_to_display")
  public int[] getGroupsToDisplay() {
    return groupsToDisplay;
  }

  public void setGroupsToDisplay(int[] groupsToDisplay) {
    this.groupsToDisplay = Arrays.copyOf(groupsToDisplay, groupsToDisplay.length);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + groupId;
    result = prime * result + Arrays.hashCode(groupsToDisplay);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ASM other = (ASM) obj;
    if (groupId != other.groupId) {
      return false;
    }
    if (!Arrays.equals(groupsToDisplay, other.groupsToDisplay)) {
      return false;
    }
    return true;
  }
}