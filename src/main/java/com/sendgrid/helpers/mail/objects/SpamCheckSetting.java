package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class SpamCheckSetting {
  @JsonProperty("enable") private boolean enable;
  @JsonProperty("threshold") private int spamThreshold;
  @JsonProperty("post_to_url") private String postToUrl;

  @JsonProperty("enable")
  public boolean getEnable() {
    return enable;
  }
  
  public void setEnable(boolean enable) {
    this.enable = enable;
  }
  
  @JsonProperty("threshold")
  public int getSpamThreshold() {
    return spamThreshold;
  }
  
  public void setSpamThreshold(int spamThreshold) {
    this.spamThreshold = spamThreshold;
  }
  
  @JsonProperty("post_to_url")
  public String getPostToUrl() {
    return postToUrl;
  }
  
  public void setPostToUrl(String postToUrl) {
    this.postToUrl = postToUrl;
  }
}