package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class FooterSetting {
  @JsonProperty("enable") private boolean enable;
  @JsonProperty("text") private String text;
  @JsonProperty("html") private String html;
  
  @JsonProperty("enable")
  public boolean getEnable() {
    return enable;
  }

  public void setEnable(boolean enable) {
    this.enable = enable;
  }
  
  @JsonProperty("text")
  public String getText() {
    return text;
  }
  
  public void setText(String text) {
    this.text = text;
  }
  
  @JsonProperty("html")
  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }
}