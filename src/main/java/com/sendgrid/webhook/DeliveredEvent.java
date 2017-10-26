package com.sendgrid.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveredEvent extends DeliveryEvent {

  @JsonProperty("response")
  private String response;

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }
}
