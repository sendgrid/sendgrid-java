package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class ClickTrackingSetting {
	@JsonProperty("enable")
	private boolean enable;
	@JsonProperty("enable_text")
	private boolean enableText;

	@JsonProperty("enable")
	public boolean getEnable() {
		return this.enable;
	}

	public ClickTrackingSetting setEnable(final boolean enable) {
		this.enable = enable;
		return this;
	}

	@JsonProperty("enable_text")
	public boolean getEnableText() {
		return this.enableText;
	}

	public ClickTrackingSetting setEnableText(final boolean enableText) {
		this.enableText = enableText;
		return this;
	}
}