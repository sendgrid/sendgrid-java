package com.sendgrid.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeferredEvent extends DeliveryEvent {

  @JsonProperty("response")
  private String response;
  @JsonProperty("attempt")
  private String attempt;

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public String getAttempt() {
    return attempt;
  }

  public void setAttempt(String attempt) {
    this.attempt = attempt;
  }
}
