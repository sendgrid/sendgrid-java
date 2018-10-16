package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

/**
 * A subscription tracking object allows you to save subscription
 * tracking settings. Subscription tracking allows you to insert
 * a subscription management link at the bottom of the text and
 * html bodies of your email. If you would like to specify the
 * location of the link within your email, you may use the
 * replacement_tag. You can also set a custom landing page url
 * or sendgrid landing page to redirect users when they unsubscribe.
 */
@JsonInclude(Include.NON_EMPTY)
public class SubscriptionTracking {

  /** The status of the subscription tracking. */
  @JsonProperty("enabled")
  private boolean enabled;

  /** The text body of the unsubscribe message. */
  @JsonProperty("plain_content")
  private String plainContent;

  /** The html body of the unsubscribe message. */
  @JsonProperty("html_content")
  private String htmlContent;
  
  /** The replacement tag for the location of the unsubscribe message in the email. */
  @JsonProperty("replace")
  private String replacementTag;

  /** The html body of the sendgrid landing page. */
  @JsonProperty("landing")
  private String sendgridLandingPageHtml;

  /** The url of the custom landing page. */
  @JsonProperty("url")
  private String customLandingPageUrl;

  /** The jackson ObjectMapper to get JSON representation of SubscriptionTracking */
  private final ObjectMapper SORTED_MAPPER = new ObjectMapper();

  /**
   * Get the status of subscription tracking. Default value is false.
   * @return the status
   */
  @JsonProperty("enabled")
  public boolean getEnabled() {
    return enabled;
  }
 
  /**
   * Set the status of the subscription tracking.
   * @param enabled the status
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * Get the text body of the unsubscribe message or null if not set
   * @return the text body
   */
  @JsonProperty("plain_content")
  public String getPlainContent() {
    return plainContent;
  }
  
  /**
   * Set the text body of the unsubscribe message.
   * @param plainContent the text body
   */
  public void setPlainContent(String plainContent) {
    this.plainContent = plainContent;
  }
  
  /**
   * Get the html body of the unsubscribe message or null if not set
   * @return the html body
   */
  @JsonProperty("html_content")
  public String getHtmlContent() {
    return htmlContent;
  } 

  /**
   * Set the html body of the unsubscribe message.
   * @param htmlContent the html body
   */
  public void setHtmlContent(String htmlContent) {
    this.htmlContent = htmlContent;
  }
  
  /**
   * Get the replacement tag for the location of the unsubscribe message in the email or null if not set
   * @return the replacement tag
   */
  @JsonProperty("replace")
  public String getReplacementTag() {
    return replacementTag;
  }  

  /**
   * Set the replacement tag for the location of the unsubscribe message in the email
   * @param replacementTag the replacement tag
   */
  public void setReplacementTag(String replacementTag) {
    this.replacementTag = replacementTag;
  }

  /**
   * Get the html body of the sendgrid landing page or null if not set
   * @return the html body
   */
  @JsonProperty("landing")
  public String getSendGridLandingPageHtml() {
    return sendgridLandingPageHtml;
  } 

  /**
   * Set the html body of the sendgrid landing page
   * @param sendgridLandingPageHtml the html body
   */
  public void setSendGridLandingPageHtml(String sendgridLandingPageHtml) {
    this.sendgridLandingPageHtml = sendgridLandingPageHtml;
  }

  /**
   * Get the url of the custom landing page or null if not set
   * @return the url
   */
  @JsonProperty("url")
  public String getCustomLandingPageUrl() {
    return customLandingPageUrl;
  } 

  /**
   * Set the url of the custom landing page
   * @param customLandingPageUrl the url
   */
  public void setCustomLandingPageUrl(String customLandingPageUrl) {
    this.customLandingPageUrl = customLandingPageUrl;
  }

  /**
   * Create a string represenation of the SubscriptionTracking object JSON.
   * @return a JSON string.
   * @throws IOException in case of a JSON marshal error.
   */
  public String build() throws IOException {
    try {
      return SORTED_MAPPER.writeValueAsString(this);
    } catch (IOException ex) {
      throw ex;
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (enabled ? 1231 : 1237);
    result = prime * result + ((htmlContent == null) ? 0 : htmlContent.hashCode());
    result = prime * result + ((replacementTag == null) ? 0 : replacementTag.hashCode());
    result = prime * result + ((plainContent == null) ? 0 : plainContent.hashCode());
    result = prime * result + ((customLandingPageUrl == null) ? 0 : customLandingPageUrl.hashCode());
    result = prime * result + ((sendgridLandingPageHtml == null) ? 0 : sendgridLandingPageHtml.hashCode());
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
    SubscriptionTracking other = (SubscriptionTracking) obj;
    if (enabled != other.enabled)
      return false;
    if (htmlContent == null) {
      if (other.htmlContent != null)
        return false;
    } else if (!htmlContent.equals(other.htmlContent))
      return false;
    if (replacementTag == null) {
      if (other.replacementTag != null)
        return false;
    } else if (!replacementTag.equals(other.replacementTag))
      return false;
    if (plainContent == null) {
      if (other.plainContent != null)
        return false;
    } else if (!plainContent.equals(other.plainContent))
      return false;
    if (customLandingPageUrl == null) {
      if (other.customLandingPageUrl != null)
        return false;
    } else if (!customLandingPageUrl.equals(other.customLandingPageUrl))
      return false;
    if (sendgridLandingPageHtml == null) {
      if (other.sendgridLandingPageHtml != null)
        return false;
    } else if (!sendgridLandingPageHtml.equals(other.sendgridLandingPageHtml))
      return false;
    return true;
  }
}