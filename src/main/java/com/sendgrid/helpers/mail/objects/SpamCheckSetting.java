package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A setting object that allows you to test the content of your email for spam.
 */
@JsonInclude(Include.NON_EMPTY)
public class SpamCheckSetting {

  @JsonProperty("enable")
  private boolean enable;

  @JsonProperty("threshold")
  private int spamThreshold;

  @JsonProperty("post_to_url")
  private String postToUrl;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (enable ? 1231 : 1237);
    result = prime * result + ((postToUrl == null) ? 0 : postToUrl.hashCode());
    result = prime * result + spamThreshold;
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
    SpamCheckSetting other = (SpamCheckSetting) obj;
    if (enable != other.enable) {
      return false;
    }
    if (postToUrl == null) {
      if (other.postToUrl != null) {
        return false;
      }
    } else if (!postToUrl.equals(other.postToUrl)) {
      return false;
    }
    if (spamThreshold != other.spamThreshold) {
      return false;
    }
    return true;
  }
}