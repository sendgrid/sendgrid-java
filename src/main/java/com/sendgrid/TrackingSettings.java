package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object representing the settings to determine how 
 * you would like to track the metrics of how your recipients 
 * interact with your email.
 */
@JsonInclude(Include.NON_DEFAULT)
public class TrackingSettings {
  @JsonProperty("click_tracking") private ClickTrackingSetting clickTrackingSetting;
  @JsonProperty("open_tracking") private OpenTrackingSetting openTrackingSetting;
  @JsonProperty("subscription_tracking") private SubscriptionTrackingSetting subscriptionTrackingSetting;
  @JsonProperty("ganalytics") private GoogleAnalyticsSetting googleAnalyticsSetting;

  /**
   * Get the click tracking setting. Click tracking allows you to 
   * track whether a recipient clicked a link in your email.
   * @return the setting.
   */
  @JsonProperty("click_tracking")
  public ClickTrackingSetting getClickTrackingSetting() {
    return clickTrackingSetting;
  }
  
  /**
   * Set the click tracking setting.
   * @param clickTrackingSetting the setting.
   */
  public void setClickTrackingSetting(ClickTrackingSetting clickTrackingSetting) {
    this.clickTrackingSetting = clickTrackingSetting;
  }
  
  /**
   * Get the open tracking setting. The open tracking allows you to 
   * track whether the email was opened or not, but including a single
   * pixel image in the body of the content. When the pixel is loaded, we can log that the email was opened.
   * @return the setting.
   */
  @JsonProperty("open_tracking")
  public OpenTrackingSetting getOpenTrackingSetting() {
    return openTrackingSetting;
  }
  
  /**
   * Set the open tracking setting.
   * @param openTrackingSetting the setting.
   */
  public void setOpenTrackingSetting(OpenTrackingSetting openTrackingSetting) {
    this.openTrackingSetting = openTrackingSetting;
  }
  
  /**
   * Get the subscription tracking setting. The subscription 
   * tracking setting allows you to insert a subscription 
   * management link at the bottom of the text and html bodies 
   * of your email. If you would like to specify the location 
   * of the link within your email, you may use the substitution_tag.
   * @return the setting.
   */
  @JsonProperty("subscription_tracking")
  public SubscriptionTrackingSetting getSubscriptionTrackingSetting() {
    return subscriptionTrackingSetting;
  }
  
  /**
   * Set the subscription tracking setting.
   * @param subscriptionTrackingSetting the setting.
   */
  public void setSubscriptionTrackingSetting(SubscriptionTrackingSetting subscriptionTrackingSetting) {
    this.subscriptionTrackingSetting = subscriptionTrackingSetting;
  }
  
  /**
   * Get the Google Analytics setting. This setting allows you to 
   * enable tracking provided by Google Analytics.
   * @return the setting.
   */
  @JsonProperty("ganalytics")
  public GoogleAnalyticsSetting getGoogleAnalyticsSetting() {
    return googleAnalyticsSetting;
  }
  
  /**
   * Set the Google Analytics setting.
   * @param googleAnalyticsSetting the setting.
   */
  public void setGoogleAnalyticsSetting(GoogleAnalyticsSetting googleAnalyticsSetting) {
    this.googleAnalyticsSetting = googleAnalyticsSetting;
  }
}
