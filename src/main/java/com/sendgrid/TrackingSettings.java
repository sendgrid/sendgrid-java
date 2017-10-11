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

    @JsonProperty("click_tracking")
    private ClickTrackingSettings clickTrackingSettings;

    @JsonProperty("open_tracking")
    private OpenTrackingSettings openTrackingSettings;

    @JsonProperty("subscription_tracking")
    private SubscriptionTrackingSettings subscriptionTrackingSettings;

    @JsonProperty("ganalytics")
    private GoogleAnalyticsSettings googleAnalyticsSettings;

    /**
     * Get the click tracking settings. Click tracking allows you to 
     * track whether a recipient clicked a link in your email.
     * @return the settings.
     */
    @JsonProperty("click_tracking")
    public ClickTrackingSettings getClickTrackingSettings() {
        return clickTrackingSettings;
    }

    /**
     * Set the click tracking settings.
     * @param clickTrackingSettings the settings.
     */
    public void setClickTrackingSettings(ClickTrackingSettings clickTrackingSettings) {
        this.clickTrackingSettings = clickTrackingSettings;
    }

    /**
     * Get the open tracking settings. The open tracking allows you to 
     * track whether the email was opened or not, but including a single
     * pixel image in the body of the content. When the pixel is loaded, we can log that the email was opened.
     * @return the settings.
     */
    @JsonProperty("open_tracking")
    public OpenTrackingSettings getOpenTrackingSettings() {
        return openTrackingSettings;
    }

    /**
     * Set the open tracking settings.
     * @param openTrackingSettings the settings.
     */
    public void setOpenTrackingSettings(OpenTrackingSettings openTrackingSettings) {
        this.openTrackingSettings = openTrackingSettings;
    }

    /**
     * Get the subscription tracking settings. The subscription 
     * tracking setting allows you to insert a subscription 
     * management link at the bottom of the text and html bodies 
     * of your email. If you would like to specify the location 
     * of the link within your email, you may use the substitution_tag.
     * @return the settings.
     */
    @JsonProperty("subscription_tracking")
    public SubscriptionTrackingSettings getSubscriptionTrackingSettings() {
        return subscriptionTrackingSettings;
    }

    /**
     * Set the subscription tracking settings.
     * @param subscriptionTrackingSettings the settings.
     */
    public void setSubscriptionTrackingSetting(SubscriptionTrackingSettings subscriptionTrackingSettings) {
        this.subscriptionTrackingSettings = subscriptionTrackingSettings;
    }

    /**
     * Get the Google Analytics settings. This setting allows you to 
     * enable tracking provided by Google Analytics.
     * @return the settings.
     */
    @JsonProperty("ganalytics")
    public GoogleAnalyticsSettings getGoogleAnalyticsSettings() {
        return googleAnalyticsSettings;
    }

    /**
     * Set the Google Analytics settings.
     * @param googleAnalyticsSettings the settings.
     */
    public void setGoogleAnalyticsSettings(GoogleAnalyticsSettings googleAnalyticsSettings) {
        this.googleAnalyticsSettings = googleAnalyticsSettings;
    }
}
