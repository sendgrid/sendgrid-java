package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class Email {
  @JsonProperty("name") private String name;
  @JsonProperty("email") private String email;

  public Email() {
    return;
  }

  public Email(String email) {
    this.setEmail(email);
  }

  public Email(String email, String name) {
    this.setEmail(email);
    this.setName(name);
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}