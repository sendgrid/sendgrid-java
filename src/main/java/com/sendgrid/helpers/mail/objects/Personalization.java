package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(Include.NON_DEFAULT)
public class Personalization {
  @JsonProperty("to") private List<Email> to;
  @JsonProperty("cc") private List<Email> cc;
  @JsonProperty("bcc") private List<Email> bcc;
  @JsonProperty("subject") private String subject;
  @JsonProperty("headers") private Map<String,String> headers;
  @JsonProperty("substitutions") private Map<String,String> substitutions;
  @JsonProperty("custom_args") private Map<String,String> customArgs;
  @JsonProperty("send_at") private long sendAt;

  @JsonProperty("to") 
  public List<Email> getTo() {
    return to;
  }
  
  public void addTo(Email email) {
    Email newEmail = new Email();
    newEmail.setName(email.getName());
    newEmail.setEmail(email.getEmail());
    if (to == null) {
      to = new ArrayList<Email>();
      to.add(newEmail);
    } else {
      to.add(newEmail);
    }        
  }

  @JsonProperty("cc") 
  public List<Email> getCc() {
    return cc;
  }
   
  public void addCc(Email email) {
    Email newEmail = new Email();
    newEmail.setName(email.getName());
    newEmail.setEmail(email.getEmail());
    if (cc == null) {
      cc = new ArrayList<Email>();
      cc.add(newEmail);
    } else {
      cc.add(newEmail);
    }
  }
  
  @JsonProperty("bcc") 
  public List<Email> getBcc() {
    return bcc;
  }

  public void addBcc(Email email) {
    Email newEmail = new Email();
    newEmail.setName(email.getName());
    newEmail.setEmail(email.getEmail());
    if (bcc == null) {
      bcc = new ArrayList<Email>();
      bcc.add(newEmail);
    } else {
      bcc.add(newEmail);
    }
  }
  
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }
  
  public void setSubject(String subject) {
    this.subject = subject;
  }
  
  @JsonProperty("headers")
  public Map<String,String> getHeaders() {
    return headers;
  }
  
  public void addHeader(String key, String value) {
    if (headers == null) {
      headers = new HashMap<String,String>();
      headers.put(key, value);
    } else {
      headers.put(key, value);
    }
  }
  
  @JsonProperty("substitutions")
  public Map<String,String> getSubstitutions() {
    return substitutions;
  }
  
  public void addSubstitution(String key, String value) {
    if (substitutions == null) {
      substitutions = new HashMap<String,String>();
      substitutions.put(key, value);
    } else {
      substitutions.put(key, value);
    }
  }
  
  @JsonProperty("custom_args")
  public Map<String,String> getCustomArgs() {
    return customArgs;
  }

  public void addCustomArg(String key, String value) {
    if (customArgs == null) {
      customArgs = new HashMap<String,String>();
      customArgs.put(key, value);
    } else {
      customArgs.put(key, value);
    }
  }
  
  @JsonProperty("send_at")
  public long sendAt() {
    return sendAt;
  }
  
  public void setSendAt(long sendAt) {
    this.sendAt = sendAt;
  }
}