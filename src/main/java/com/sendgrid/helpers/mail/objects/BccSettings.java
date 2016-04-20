package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class BccSettings {
    @JsonProperty("enable") private boolean enable;
    @JsonProperty("email") private Email email;
    
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    
    @JsonProperty("enable")
    public boolean getEnable() {
        return enable;
    }
    
    public void setEmail(Email email) {
        this.email = email;
    }
    
    @JsonProperty("email")
    public Email getEmail() {
        return this.email;
    }   
}