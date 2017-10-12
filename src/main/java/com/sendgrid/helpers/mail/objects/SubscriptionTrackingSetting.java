package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A subscription tracking setting object. Subscription tracking 
 * allows you to insert a subscription management link at the 
 * bottom of the text and html bodies of your email. If you 
 * would like to specify the location of the link within your 
 * email, you may use the substitution_tag.
 */
@JsonInclude(Include.NON_EMPTY)
public class SubscriptionTrackingSetting {
  @JsonProperty("enable") private boolean enable;
  @JsonProperty("text") private String text;
  @JsonProperty("html") private String html;
  @JsonProperty("substitution_tag") private String substitutionTag;
  
  /**
   * Determines if this setting is enabled.
   * @return true if subscription tracking is enabled, false otherwise.
   */
  @JsonProperty("enable")
  public boolean getEnable() {
    return enable;
  }
 
  /**
   * Set if this setting is enabled.
   * @param enable true if subscription tracking is enabled, false otherwise.
   */
  public void setEnable(boolean enable) {
    this.enable = enable;
  }
  
  /**
   * Get the plain text to be appended to the email, with the 
   * subscription tracking link. You may control where 
   * the link is by using the tag &lt;% %&gt;
   * @return the plain text.
   */
  @JsonProperty("text")
  public String getText() {
    return text;
  }
  
  /** 
   * Set the plain text.
   * @param text the plain text.
   */
  public void setText(String text) {
    this.text = text;
  }
  
  /**
   * Get the HTML to be appended to the email, with the 
   * subscription tracking link. You may control where 
   * the link is by using the tag &lt;% %&gt;
   * @return the HTML.
   */
  @JsonProperty("html")
  public String getHtml() {
    return html;
  } 

  /**
   * Set the HTML.
   * @param html the HTML.
   */
  public void setHtml(String html) {
    this.html = html;
  }
  
  /**
   * Get the  tag that will be replaced with the 
   * unsubscribe URL. for example: [unsubscribe_url].
   * If this parameter is used, it will override both 
   * the text and html parameters. The URL of the link 
   * will be placed at the substitution tag’s location, 
   * with no additional formatting.
   * @return the substitution tag.
   */
  @JsonProperty("substitution_tag")
  public String getSubstitutionTag() {
    return substitutionTag;
  }  

  /**
   * Set the substitution tag.
   * @param substitutionTag the substitution tag.
   */
  public void setSubstitutionTag(String substitutionTag) {
    this.substitutionTag = substitutionTag;
  }
}
