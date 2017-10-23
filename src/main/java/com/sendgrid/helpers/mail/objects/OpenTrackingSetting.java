package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An open tracking settings object. This allows you to track 
 * whether the email was opened or not, but including a single 
 * pixel image in the body of the content. When the pixel is 
 * loaded, we can log that the email was opened.
 */
@JsonInclude(Include.NON_DEFAULT)
public class OpenTrackingSetting {
  @JsonProperty("enable") private boolean enable;
  @JsonProperty("substitution_tag") private String substitutionTag;
  
  /**
   * Determines if this setting is enabled.
   * @return true if open tracking is enabled, false otherwise.
   */
  @JsonProperty("enable")
  public boolean getEnable() {
    return enable;
  }
  
  /**
   * Set if this setting is enabled.
   * @param enable true if open tracking is enabled, false otherwise.
   */
  public void setEnable(boolean enable) {
    this.enable = enable;
  }
  
  /**
   * Get the substituion tag. This allows you to specify a 
   * substitution tag that you can insert in the body of 
   * your email at a location that you desire. This tag will 
   * be replaced by the open tracking pixel.
   * @return the substitution tag.
   */
  @JsonProperty("substitution_tag")
  public String getSubstitutionTag() {
    return substitutionTag;
  }
  
  /**
   * Set the substitution tag.
   * @param substitutionTag the substitution tag.
   */
  public void setSubstitutionTag(String substitutionTag) {
    this.substitutionTag = substitutionTag;
  }
}
