package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object in which you may specify the content of your email. 
 */
@JsonInclude(Include.NON_DEFAULT)
public class Content {
  @JsonProperty("type") private String type;
  @JsonProperty("value") private String  value;

  /**
   * Construct an empty content object.
   */
  public Content() {
    
  }

  /**
   * Construct a content object with the specified type and value.
   * @param type the mime type.
   * @param value the content.
   */
  public Content(String type, String value) {
    this.setType(type);
    this.setValue(value);
  }

  /**
   * Get the mime type of the content you are including 
   * in your email. For example, “text/plain” or “text/html”.
   * @return the mime type.
   */
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  /**
   * Set the mime type of the content you are including 
   * in your email. For example, “text/plain” or “text/html”.
   * @param type the mime type.
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Get the actual content of the specified mime type 
   * that you are including in your email.
   * @return the value.
   */
  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  /**
   * Set the actual content of the specified mime type 
   * that you are including in your email.
   * @param value the value.
   */
  public void setValue(String value) {
    this.value = value;
  }
}
