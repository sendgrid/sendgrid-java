package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class TrackingSettings {
  @JsonProperty("click_tracking") private ClickTrackingSetting clickTrackingSetting;
  @JsonProperty("open_tracking") private OpenTrackingSetting openTrackingSetting;
  @JsonProperty("subscription_tracking") private SubscriptionTrackingSetting subscriptionTrackingSetting;
  @JsonProperty("ganalytics") private GoogleAnalyticsSetting googleAnalyticsSetting;

  @JsonProperty("click_tracking")
  public ClickTrackingSetting getClickTrackingSetting() {
    return clickTrackingSetting;
  }
  
  public void setClickTrackingSetting(ClickTrackingSetting clickTrackingSetting) {
    this.clickTrackingSetting = clickTrackingSetting;
  }
  
  @JsonProperty("open_tracking")
  public OpenTrackingSetting getOpenTrackingSetting() {
    return openTrackingSetting;
  }
  
  public void setOpenTrackingSetting(OpenTrackingSetting openTrackingSetting) {
    this.openTrackingSetting = openTrackingSetting;
  }
  
  @JsonProperty("subscription_tracking")
  public SubscriptionTrackingSetting getSubscriptionTrackingSetting() {
    return subscriptionTrackingSetting;
  }
  
  public void setSubscriptionTrackingSetting(SubscriptionTrackingSetting subscriptionTrackingSetting) {
    this.subscriptionTrackingSetting = subscriptionTrackingSetting;
  }
  
  @JsonProperty("ganalytics")
  public GoogleAnalyticsSetting getGoogleAnalyticsSetting() {
    return googleAnalyticsSetting;
  }
  
  public void setGoogleAnalyticsSetting(GoogleAnalyticsSetting googleAnalyticsSetting) {
    this.googleAnalyticsSetting = googleAnalyticsSetting;
  }
}