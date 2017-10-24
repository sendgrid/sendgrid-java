package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An email address represented as an address name pair.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Email {
  @JsonProperty("name") private String name;
  @JsonProperty("email") private String email;

  /**
   * Construct an empty email.
   */
  public Email() {
    
  }

  /**
   * Construct an email with the supplied email and an empty name.
   * @param email an email address.
   */
  public Email(String email) {
    this.setEmail(email);
  }

  /**
   * Construct an email with the supplied address and name.
   * @param email an email address.
   * @param name a name.
   */
  public Email(String email, String name) {
    this.setEmail(email);
    this.setName(name);
  }

  /**
   * Get the name.
   * @return the name.
   */
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  /**
   * Set the name.
   * @param name the name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the email address.
   * @return the email address.
   */
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  /**
   * Set the email address.
   * @param email the email address.
   */
  public void setEmail(String email) {
    this.email = email;
  }
}
