package com.sendgrid.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BounceEvent extends DeliveryEvent {

  @JsonProperty("status")
  protected String status;
  @JsonProperty("reason")
  protected String reason;
  @JsonProperty("type")
  protected String type;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
