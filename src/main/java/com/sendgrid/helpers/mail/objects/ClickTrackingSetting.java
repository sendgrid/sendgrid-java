package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class ClickTrackingSetting {
  @JsonProperty("enable") private boolean enable;
  @JsonProperty("enable_text") private boolean enableText;
 
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
}