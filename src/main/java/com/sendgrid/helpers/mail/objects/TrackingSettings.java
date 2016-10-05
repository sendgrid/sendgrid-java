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
		return this.clickTrackingSetting;
	}

	public TrackingSettings setClickTrackingSetting(final ClickTrackingSetting clickTrackingSetting) {
		this.clickTrackingSetting = clickTrackingSetting;
		return this;
	}

	@JsonProperty("open_tracking")
	public OpenTrackingSetting getOpenTrackingSetting() {
		return this.openTrackingSetting;
	}

	public TrackingSettings setOpenTrackingSetting(final OpenTrackingSetting openTrackingSetting) {
		this.openTrackingSetting = openTrackingSetting;
		return this;
	}

	@JsonProperty("subscription_tracking")
	public SubscriptionTrackingSetting getSubscriptionTrackingSetting() {
		return this.subscriptionTrackingSetting;
	}

	public TrackingSettings setSubscriptionTrackingSetting(final SubscriptionTrackingSetting subscriptionTrackingSetting) {
		this.subscriptionTrackingSetting = subscriptionTrackingSetting;
		return this;
	}

	@JsonProperty("ganalytics")
	public GoogleAnalyticsSetting getGoogleAnalyticsSetting() {
		return this.googleAnalyticsSetting;
	}

	public TrackingSettings setGoogleAnalyticsSetting(final GoogleAnalyticsSetting googleAnalyticsSetting) {
		this.googleAnalyticsSetting = googleAnalyticsSetting;
		return this;
	}
}