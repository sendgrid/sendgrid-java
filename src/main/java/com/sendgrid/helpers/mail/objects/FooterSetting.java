package com.sendgrid.helpers.mail.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class FooterSetting {
	@JsonProperty("enable")
	private boolean enable;
	@JsonProperty("text")
	private String text;
	@JsonProperty("html")
	private String html;

	@JsonProperty("enable")
	public boolean getEnable() {
		return this.enable;
	}

	public FooterSetting setEnable(final boolean enable) {
		this.enable = enable;
		return this;
	}

	@JsonProperty("text")
	public String getText() {
		return this.text;
	}

	public FooterSetting setText(final String text) {
		this.text = text;
		return this;
	}

	@JsonProperty("html")
	public String getHtml() {
		return this.html;
	}

	public FooterSetting setHtml(final String html) {
		this.html = html;
		return this;
	}
}