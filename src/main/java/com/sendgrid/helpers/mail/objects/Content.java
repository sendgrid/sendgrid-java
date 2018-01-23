package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.lang.IllegalArgumentException;

/**
 * An object in which you may specify the content of your email. 
 */
@JsonInclude(Include.NON_DEFAULT)
public class Content {
  @JsonProperty("type") private String type;
  @JsonProperty("value") private String  value;

  public Content() {
    return;
  }

  public Content(String type, String value) {
    this.setType(type);
    this.setValue(value);
  }

  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    ContentVerifier.verifyContent(value);
    this.value = value;
  }



  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    result = prime * result + ((value == null) ? 0 : value.hashCode());
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
    Content other = (Content) obj;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }
}

class ContentVerifier {
    private static final List<Pattern> FORBIDDEN_PATTERNS = Collections.singletonList(
            Pattern.compile(".*SG\\.[a-zA-Z0-9(-|_)]*\\.[a-zA-Z0-9(-|_)]*.*")
    );

    static void verifyContent(String content) {
      for (Pattern pattern: FORBIDDEN_PATTERNS) {
        if (pattern.matcher(content).matches()) {
          throw new IllegalArgumentException("Found a Forbidden Pattern in the content of the email");
        }
      }
    }
}

