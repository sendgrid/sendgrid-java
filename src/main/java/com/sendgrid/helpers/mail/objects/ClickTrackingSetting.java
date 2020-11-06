package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Settings to determine how you would like to track the metrics of how your recipients interact
 * with your email.
 */
@JsonInclude(Include.NON_EMPTY)
public class ClickTrackingSetting {

  @JsonProperty("enable")
  private boolean enable;

  @JsonProperty("enable_text")
  private boolean enableText;

  @JsonProperty("enable")
  public boolean getEnable() {
    return enable;
  }

  public void setEnable(boolean enable) {
    this.enable = enable;
  }

  @JsonProperty("enable_text")
  public boolean getEnableText() {
    return enableText;
  }

  public void setEnableText(boolean enableText) {
    this.enableText = enableText;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (enable ? 1231 : 1237);
    result = prime * result + (enableText ? 1231 : 1237);
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
    ClickTrackingSetting other = (ClickTrackingSetting) obj;
    if (enable != other.enable) {
      return false;
    }
    if (enableText != other.enableText) {
      return false;
    }
    return true;
  }
}