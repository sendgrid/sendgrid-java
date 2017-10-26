package com.sendgrid.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupUnsubscribeEvent extends EngagementEvent {

  @JsonProperty("asm_group_id")
  private long asmGroupId;

  public long getAsmGroupId() {
    return asmGroupId;
  }

  public void setAsmGroupId(long asmGroupId) {
    this.asmGroupId = asmGroupId;
  }
}
