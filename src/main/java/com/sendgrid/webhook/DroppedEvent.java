package com.sendgrid.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DroppedEvent extends DeliveryEvent {

  @JsonProperty("reason")
  private String reason;

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }
}
