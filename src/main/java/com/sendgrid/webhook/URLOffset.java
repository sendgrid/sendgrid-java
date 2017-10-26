package com.sendgrid.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class URLOffset {

  @JsonProperty("index")
  private int index;
  @JsonProperty("type")
  private String type;

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
