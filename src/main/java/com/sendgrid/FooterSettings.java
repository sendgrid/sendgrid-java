package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object representing the default footer 
 * that you would like included on every email.
 */
@JsonInclude(Include.NON_DEFAULT)
public class FooterSettings {

  @JsonProperty("enable") private boolean enable;

  @JsonProperty("text") private String text;

  @JsonProperty("html") private String html;
  
  /**
   * Get whether or not the footer is enabled.
   * @return true if the footer is enabled, false otherwise.
   */
  @JsonProperty("enable")
  public boolean getEnable() {
    return enable;
  }

  /**
   * Set whether or not the footer is enabled.
   * @param enable true if the footer is enabled, false otherwise.
   */
  public void setEnable(boolean enable) {
    this.enable = enable;
  }
  
  /**
   * Get the plain text content of the footer.
   * @return the footer plain text.
   */
  @JsonProperty("text")
  public String getText() {
    return text;
  }
  
  /**
   * Set the plain text content of the footer.
   * @param text the footer plain text.
   */
  public void setText(String text) {
    this.text = text;
  }
  
  /**
   * Get the HTML content of the footer.
   * @return the footer HTML.
   */
  @JsonProperty("html")
  public String getHtml() {
    return html;
  }

  /**
   * Set the HTML content of the footer.
   * @param html the footer HTML.
   */
  public void setHtml(String html) {
    this.html = html;
  }
}
