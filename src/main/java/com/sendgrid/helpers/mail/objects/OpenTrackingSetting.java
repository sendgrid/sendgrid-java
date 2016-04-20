package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class OpenTrackingSetting {
    @JsonProperty("enable") private boolean enable;
    @JsonProperty("substitution_tag") private String substitutionTag;
    
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }
    
    public void setSubstitutionTag(String substitutionTag) {
        this.substitutionTag = substitutionTag;
    }
    
    @JsonProperty("substitution_tag")
    public String getSubstitutionTag() {
        return substitutionTag;
    }
}