package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class SpamCheckSetting {
	@JsonProperty("enable")
	private boolean enable;
	@JsonProperty("threshold")
	private int spamThreshold;
	@JsonProperty("post_to_url")
	private String postToUrl;

	@JsonProperty("enable")
	public boolean getEnable() {
		return this.enable;
	}

	public SpamCheckSetting setEnable(final boolean enable) {
		this.enable = enable;
		return this;
	}

	@JsonProperty("threshold")
	public int getSpamThreshold() {
		return this.spamThreshold;
	}

	public SpamCheckSetting setSpamThreshold(final int spamThreshold) {
		this.spamThreshold = spamThreshold;
		return this;
	}

	@JsonProperty("post_to_url")
	public String getPostToUrl() {
		return this.postToUrl;
	}

	public SpamCheckSetting setPostToUrl(final String postToUrl) {
		this.postToUrl = postToUrl;
		return this;
	}
}