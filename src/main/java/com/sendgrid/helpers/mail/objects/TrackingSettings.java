package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class TrackingSettings {

  @JsonProperty("click_tracking")
  private ClickTrackingSetting clickTrackingSetting;

  @JsonProperty("open_tracking")
  private OpenTrackingSetting openTrackingSetting;

  @JsonProperty("subscription_tracking")
  private SubscriptionTrackingSetting subscriptionTrackingSetting;

  @JsonProperty("ganalytics")
  private GoogleAnalyticsSetting googleAnalyticsSetting;

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

  public void setSubscriptionTrackingSetting(
      SubscriptionTrackingSetting subscriptionTrackingSetting) {
    this.subscriptionTrackingSetting = subscriptionTrackingSetting;
  }

  @JsonProperty("ganalytics")
  public GoogleAnalyticsSetting getGoogleAnalyticsSetting() {
    return googleAnalyticsSetting;
  }

  public void setGoogleAnalyticsSetting(GoogleAnalyticsSetting googleAnalyticsSetting) {
    this.googleAnalyticsSetting = googleAnalyticsSetting;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
        prime * result + ((clickTrackingSetting == null) ? 0 : clickTrackingSetting.hashCode());
    result =
        prime * result + ((googleAnalyticsSetting == null) ? 0 : googleAnalyticsSetting.hashCode());
    result = prime * result + ((openTrackingSetting == null) ? 0 : openTrackingSetting.hashCode());
    result = prime * result + ((subscriptionTrackingSetting == null) ? 0
        : subscriptionTrackingSetting.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    TrackingSettings other = (TrackingSettings) obj;
    if (clickTrackingSetting == null) {
      if (other.clickTrackingSetting != null) {
        return false;
      }
    } else if (!clickTrackingSetting.equals(other.clickTrackingSetting)) {
      return false;
    }
    if (googleAnalyticsSetting == null) {
      if (other.googleAnalyticsSetting != null) {
        return false;
      }
    } else if (!googleAnalyticsSetting.equals(other.googleAnalyticsSetting)) {
      return false;
    }
    if (openTrackingSetting == null) {
      if (other.openTrackingSetting != null) {
        return false;
      }
    } else if (!openTrackingSetting.equals(other.openTrackingSetting)) {
      return false;
    }
    if (subscriptionTrackingSetting == null) {
      if (other.subscriptionTrackingSetting != null) {
        return false;
      }
    } else if (!subscriptionTrackingSetting.equals(other.subscriptionTrackingSetting)) {
      return false;
    }
    return true;
  }
}