package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class OpenTrackingSetting {
  @JsonProperty("enable") private boolean enable;
  @JsonProperty("substitution_tag") private String substitutionTag;
  
  @JsonProperty("enable")
  public boolean getEnable() {
    return enable;
  }
  
  public void setEnable(boolean enable) {
    this.enable = enable;
  }
  
  @JsonProperty("substitution_tag")
  public String getSubstitutionTag() {
    return substitutionTag;
  }
  
  public void setSubstitutionTag(String substitutionTag) {
    this.substitutionTag = substitutionTag;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (enable ? 1231 : 1237);
    result = prime * result + ((substitutionTag == null) ? 0 : substitutionTag.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OpenTrackingSetting other = (OpenTrackingSetting) obj;
    if (enable != other.enable)
      return false;
    if (substitutionTag == null) {
      if (other.substitutionTag != null)
        return false;
    } else if (!substitutionTag.equals(other.substitutionTag))
      return false;
    return true;
  }
  
}