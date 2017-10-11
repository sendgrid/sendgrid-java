package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This object allows you to have a blind carbon copy 
 * automatically sent to the specified email address 
 * for every email that is sent.
 */
@JsonInclude(Include.NON_DEFAULT)
public class BccSettings {
  @JsonProperty("enable") private boolean enable;
  @JsonProperty("email") private String email;

  /**
   * Determines if this setting is enabled.
   * @return true if BCC is enabled, false otherwise.
   */
  @JsonProperty("enable")
  public boolean getEnable() {
    return enable;
  }

  /**
   * Set whether or not BCC is enabled.
   * @param enable true if BCC is enabled, false otherwise.
   */
  public void setEnable(boolean enable) {
    this.enable = enable;
  }

  /**
   * Get the email address that you would like to receive the BCC.
   * @return the address.
   */
  @JsonProperty("email")
  public String getEmail() {
    return this.email;
  }

  /**
   * Set the email address that you would like to receive the BCC.
   * @param email the address.
   */
  public void setEmail(String email) {
    this.email = email;
  }
}
