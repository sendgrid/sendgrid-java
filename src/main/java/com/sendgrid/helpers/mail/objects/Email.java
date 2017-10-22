package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * An email address represented as an address name pair.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Email {
  @JsonProperty("name") private String name;
  @JsonProperty("email") private String email;

  public Email() {
    return;
  }

  /**
   * Construct an email with the supplied email and an empty name.
   * @param email an email address.
   * @throws IllegalArgumentException if email have an incorrect format
   */
  public Email(String email) throws IllegalArgumentException {
    InternetAddress address;
    try {
      address = new InternetAddress(email);
      address.validate();
    } catch (final AddressException e) {
      throw new IllegalArgumentException("Incorrect email address", e);
    }

    this.email = address.getAddress();
    if (address.getPersonal() != null) {
      this.name = address.getPersonal();
    }
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    Email other = (Email) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
}