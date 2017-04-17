package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class SubscriptionTrackingSetting {
	@JsonProperty("enable")
	private boolean enable;
	@JsonProperty("text")
	private String text;
	@JsonProperty("html")
	private String html;
	@JsonProperty("substitution_tag")
	private String substitutionTag;

	@JsonProperty("enable")
	public boolean getEnable() {
		return this.enable;
	}

	public SubscriptionTrackingSetting setEnable(final boolean enable) {
		this.enable = enable;
		return this;
	}

	@JsonProperty("text")
	public String getText() {
		return this.text;
	}

	public SubscriptionTrackingSetting setText(final String text) {
		this.text = text;
		return this;
	}

	@JsonProperty("html")
	public String getHtml() {
		return this.html;
	}

	public SubscriptionTrackingSetting setHtml(final String html) {
		this.html = html;
		return this;
	}

	@JsonProperty("substitution_tag")
	public String getSubstitutionTag() {
		return this.substitutionTag;
	}

	public SubscriptionTrackingSetting setSubstitutionTag(final String substitutionTag) {
		this.substitutionTag = substitutionTag;
		return this;
	}
}