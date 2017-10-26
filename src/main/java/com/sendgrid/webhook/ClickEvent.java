package com.sendgrid.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClickEvent extends EngagementEvent {

  @JsonProperty("url")
  protected String url;
  @JsonProperty("url_offset")
  protected URLOffset urlOffset;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public URLOffset getUrlOffset() {
    return urlOffset;
  }

  public void setUrlOffset(URLOffset urlOffset) {
    this.urlOffset = urlOffset;
  }
}
