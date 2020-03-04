package com.sendgrid;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A JSON-serializable model of the settings defining how metrics
 * tracking should be performed for recipient interactions.
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
     * Gets the click tracking settings. Click tracking allows you to
     * track whether a recipient clicked a link in your email.
     *
     * @return the click tracking settings.
     */
    @JsonProperty("click_tracking")
    public ClickTrackingSettings getClickTrackingSettings() {
        return clickTrackingSettings;
    }

    /**
     * Sets the click tracking settings.
     *
     * @param clickTrackingSettings the new click tracking settings.
     * @return {@code this} for chaining.
     */
    public TrackingSettings clickTrackingSettings(ClickTrackingSettings clickTrackingSettings) {
        this.clickTrackingSettings = clickTrackingSettings;
        return this;
    }

    /**
     * Gets the open tracking settings. The open tracking allows you to
     * track whether the email was opened or not, by including a single
     * pixel image in the body of the content. When the pixel is loaded,
     * we can log that the email was opened.
     *
     * @return the open tracking settings.
     */
    @JsonProperty("open_tracking")
    public OpenTrackingSettings getOpenTrackingSettings() {
        return openTrackingSettings;
    }

    /**
     * Sets the open tracking settings.
     *
     * @param openTrackingSettings the open tracking settings.
     * @return {@code this} for chaining.
     */
    public TrackingSettings openTrackingSettings(OpenTrackingSettings openTrackingSettings) {
        this.openTrackingSettings = openTrackingSettings;
        return this;
    }

    /**
     * Gets the subscription tracking settings. The subscription
     * tracking setting allows you to insert a subscription 
     * management link at the bottom of the text and html body
     * of your email. If you would like to specify the location 
     * of the link within your email, you may use the
     * {@code substitution_tag}.
     *
     * @return the settings.
     */
    @JsonProperty("subscription_tracking")
    public SubscriptionTrackingSettings getSubscriptionTrackingSettings() {
        return subscriptionTrackingSettings;
    }

    /**
     * Sets the subscription tracking settings.
     *
     * @param subscriptionTrackingSettings the subscription tracking settings.
     * @return {@code this} for chaining.
     */
    public TrackingSettings subscriptionTrackingSetting(SubscriptionTrackingSettings subscriptionTrackingSettings) {
        this.subscriptionTrackingSettings = subscriptionTrackingSettings;
        return this;
    }

    /**
     * Gets the Google Analytics settings. This setting allows you to
     * enable tracking provided by Google Analytics.
     *
     * @return the google analytics settings.
     */
    @JsonProperty("ganalytics")
    public GoogleAnalyticsSettings getGoogleAnalyticsSettings() {
        return googleAnalyticsSettings;
    }

    /**
     * Sets the Google Analytics settings.
     *
     * @param googleAnalyticsSettings the google analytics settings.
     * @return {@code this} for chaining.
     */
    public TrackingSettings googleAnalyticsSettings(GoogleAnalyticsSettings googleAnalyticsSettings) {
        this.googleAnalyticsSettings = googleAnalyticsSettings;
        return this;
    }
}
