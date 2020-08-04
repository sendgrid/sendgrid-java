package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object representing the default footer that you would like included on every email.
 */
@JsonInclude(Include.NON_EMPTY)
public class FooterSetting {

  @JsonProperty("enable")
  private boolean enable;

  @JsonProperty("text")
  private String text;

  @JsonProperty("html")
  private String html;

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (enable ? 1231 : 1237);
    result = prime * result + ((html == null) ? 0 : html.hashCode());
    result = prime * result + ((text == null) ? 0 : text.hashCode());
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
    FooterSetting other = (FooterSetting) obj;
    if (enable != other.enable) {
      return false;
    }
    if (html == null) {
      if (other.html != null) {
        return false;
      }
    } else if (!html.equals(other.html)) {
      return false;
    }
    if (text == null) {
      if (other.text != null) {
        return false;
      }
    } else if (!text.equals(other.text)) {
      return false;
    }
    return true;
  }
}